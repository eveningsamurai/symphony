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

import com.eveningsamurai.symphony.model.ClientWebPropertyVolumeResponse;
import com.google.gson.reflect.TypeToken;

public class ClientWebPropertyVolumeRequest extends Request {
	/** Account id for the web property id */
	private String accountId;
	
	/** Tracked searches associated with the web property id */
	private String webPropertyId;

	/** Source for the search results rank */
	private String rankSourceId;
	
	/** Time period for the search results */
	private String timePeriodId;
	
	/**
	 * Constructor
	 * 
	 * Create a new request builder for client web property volume report
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 * @param accountId account id for the account
	 * @param webPropertyId the web property id for the tracked searches
	 * @param rankSourceId the rank source id for the searches
	 * @param timePeriodId the time period for the searches
	 */

	public ClientWebPropertyVolumeRequest(String apiKey, String sharedSecret, String accountId, String webPropertyId, String rankSourceId, String timePeriodId) {
		super(apiKey, sharedSecret);
		this.accountId = accountId;
		this.webPropertyId = webPropertyId;
		this.rankSourceId = rankSourceId;
		this.timePeriodId = timePeriodId;
	}
	
	/**
	 * Constructor
	 * 
	 * Create a new request builder for client web property volume report
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 * @param accountId account id for the account
	 * @param webPropertyId the web property id for the tracked searches
	 * @param rankSourceId the rank source id for the searches
	 */
	public ClientWebPropertyVolumeRequest(String apiKey, String sharedSecret, String accountId, String webPropertyId, String rankSourceId) {
		this(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId, "CURRENT");
	}

	/** Endpoint for location list request api
	 * GET v3/{accountId}/web-properties/{clientWebPropertyId}/rank-sources/{rankSourceId}/tp/CURRENT/search-volumes
	 * @return web property search volume url as string
	 */
	@Override
	public String getEndpoint() {
		return String.format("https://api.conductor.com/v3/%s/web-properties/%s/rank-sources/%s/tp/%s/search-volumes", accountId, webPropertyId, rankSourceId, timePeriodId);
	}

	/**
	 * @return gson type
	 */
	@Override
	protected Type getTypeForGson() {
		Type clientWebPropertyVolumeResponseType = new TypeToken<ClientWebPropertyVolumeResponse[]>() { }.getType();
		return clientWebPropertyVolumeResponseType;
	}
}
