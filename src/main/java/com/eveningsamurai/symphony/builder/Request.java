/*
 * Copyright (c) Avinash Padmanabhan (gmail: avinashpadmanabhan)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eveningsamurai.symphony.builder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.reflect.Type;

import com.eveningsamurai.symphony.SymphonyClientException;
import com.eveningsamurai.symphony.model.Response;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Request {
	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(Request.class.getName());
		
	/** List of query parameters for the request */
	private List<QueryParameter> paramlist = new LinkedList<QueryParameter>();
	
	/** apiKey and md5 signature query parameters that need to be tagged on to every request*/
	private String apiKey, sharedSecret, md5Sig;
		
	/** 
	 * Constructor
	 * 
	 * Construct a new Request
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 */
	public Request(String apiKey, String sharedSecret) {
		this.apiKey = apiKey;
		this.sharedSecret = sharedSecret;
		this.md5Sig = getMD5Sig();
		
		addQueryParameter(new QueryParameter("apiKey", getAPIKey()));
		addQueryParameter(new QueryParameter("sig", getMD5Sig()));
	}
	
	/**
	 *  Get the QueryParameters
	 *  @return the QueryParameters
	 */
	public List<QueryParameter> getQueryParameters() {
		return Collections.unmodifiableList(paramlist);
	}
	
	/**
	 * Sub classes must implement this method and return the endpoint
	 * @return endpoint
	 */
	public abstract String getEndpoint();

	/**
	 * GSON construct for generic types
	 * @return Type for GSON deserializer
	 */
	protected abstract Type getTypeForGson();
	
	/**
	 * @return the apiKey
	 * @throws IllegalStateException if API key is not set
	 */
	private String getAPIKey() {
		if(apiKey == null)
			throw new IllegalStateException("API Key is not set!");
		return apiKey;
	}
	
	/**
	 * @return the sharedSecret
	 * @throws IllegalStateException if shared secret is not set
	 */
	private String getSharedSecret() {
		if(sharedSecret == null)
			throw new IllegalStateException("Shared Secret is not set!");
		return sharedSecret;
	}

	/**
	 * @return the md5 signature
	 */
	private String getMD5Sig() {
		return generateMD5(getAPIKey(), getSharedSecret());
	}

	/**
	 * @param md5Sig: generate the md5
	 */
	private String generateMD5(String key, String secret) {
		String md5Text = "";
		try {
			Long currentTime = Math.round(System.currentTimeMillis() / 1000.0);
			String stringToHash = key + secret + currentTime.toString();
			MessageDigest digest = MessageDigest.getInstance("MD5");
			md5Text = new BigInteger(1, digest.digest((stringToHash).getBytes())).toString(16);
		} catch(Exception e) {
			System.out.println("Error in generating MD5 hash");
			e.printStackTrace();
		}
		return md5Text;
	}
	
	/**
	 * Add a QueryParameter to the request
	 * @param paramName : name of the parameter
	 * @param paramValue: value of the parameter 
	 */
	public void addQueryParameter(String paramName, String paramValue) {
		addQueryParameter(new QueryParameter(paramName, paramValue));
	}
	
	/**
	 * Add the QueryParameter to the parameter list
	 * @param queryParam: QueryParameter to add to the list
	 */
	public void addQueryParameter(QueryParameter queryParam) {
		paramlist.add(queryParam);
	}
	
	/**
	 * Build the URL request to be sent to the API
	 * @return URL
	 */	
	public String buildURL() {
		StringBuffer url = new StringBuffer();
		url.append(getEndpoint());
		url.append("?");
		for(QueryParameter qp: paramlist) {
			url.append(qp);
			url.append("&");
		}
		url.deleteCharAt(url.length()-1);
		return url.toString();
	}
	
	/**
	 * Send the request to the API with retry and exponential backoff
	 * @return API response
	 * @throws InterruptedException thread put to sleep for exponential backoff
	 */
	public Response[] call() throws InterruptedException {
		Response[] res = {};
		int responseCode = 0;
		Random randomGenerator = new Random();
		
		for(int n=0; n<6; n++) {
			try {
				String urlString = buildURL();
				LOG.debug("Calling URL: {}", urlString);
				URL url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect();
				responseCode = conn.getResponseCode();
				
				StringBuffer responseBuffer = new StringBuffer();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				while((line = br.readLine()) != null)
					responseBuffer.append(line);
				String response = responseBuffer.toString();
				LOG.trace("Response received: {}", response);
				
				res = getPojoFull(response);
				return res;
			} catch (Exception e) {
				if(responseCode == 403) {
					int backOffTime = (1 << n) * 1000 + randomGenerator.nextInt(1001); 
					LOG.debug("Sleeping for: {}", backOffTime);
					Thread.sleep(backOffTime);
				}
				else
					throw new SymphonyClientException(e);
			} 
		}
		LOG.error("There has been an error, the request did not succeed");
		return null;
	}
	
	/**
	 * Fully de-serialize conductor Searchlight Conductor response
	 * @param response data
	 * @return response
	 */
	private Response[] getPojoFull(String response) {
		Gson gson = new Gson();
		return gson.fromJson(response, getTypeForGson());
	}
	
} 
