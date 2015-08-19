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

import java.lang.reflect.Type;

import com.eveningsamurai.symphony.model.TrackedSearchListResponse;
import com.google.gson.reflect.TypeToken;

public class TrackedSearchListRequest extends Request {
	/** Account id for the account */
	private String accountId;
	
	/** Tracked searches associated with the web property id */
	private String webPropertyId;
	
	/**
	 * Constructor
	 * 
	 * Create a new request builder for tracked search list
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 * @param accountId account id for the account
	 * @param webPropertyId the web property id for the tracked searches
	 */
	public TrackedSearchListRequest(String apiKey, String sharedSecret, String accountId, String webPropertyId) {
		super(apiKey, sharedSecret);
		this.accountId = accountId;
		this.webPropertyId = webPropertyId;
	}
	
	/** 
	 * Endpoint for tracked searches list request api
	 * GET v3/accounts/{accountId}/web-properties/{webPropertyId}/tracked-searches
	 * @return tracked searches url for account and specified web property as string
	 */
	@Override
	public String getEndpoint() {
		return String.format("https://api.conductor.com/v3/accounts/%s/web-properties/%s/tracked-searches", accountId, webPropertyId);
	}

	/**
	 * @return gson type
	 */
	@Override
	protected Type getTypeForGson() {
		Type trackedSearchListResponseType = new TypeToken<TrackedSearchListResponse[]>() { }.getType();
		return trackedSearchListResponseType;
	}

}
