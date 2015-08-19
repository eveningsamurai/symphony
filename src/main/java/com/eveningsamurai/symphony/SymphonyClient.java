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

package com.eveningsamurai.symphony;

import com.eveningsamurai.symphony.builder.AccountRequest;
import com.eveningsamurai.symphony.builder.CategoryListRequest;
import com.eveningsamurai.symphony.builder.ClientWebPropertyVolumeRequest;
import com.eveningsamurai.symphony.builder.DeviceListRequest;
import com.eveningsamurai.symphony.builder.LocationListRequest;
import com.eveningsamurai.symphony.builder.TrackedSearchListRequest;
import com.eveningsamurai.symphony.builder.ClientWebPropertyRankRequest;
import com.eveningsamurai.symphony.builder.RankSourceListRequest;
import com.eveningsamurai.symphony.builder.WebPropertyListRequest;
import com.google.common.base.Preconditions;

public class SymphonyClient {
	private final String apiKey;
	private final String sharedSecret;
	
	/** Constructor 
	 * 
	 * @param apiKey(required) apiKey for searchlight conductor api
	 * @param sharedSecret (required) sharedSecret for searchlight conductor api
	 * */
	public SymphonyClient(String apiKey, String sharedSecret) {
		this.apiKey = Preconditions.checkNotNull(apiKey);
		this.sharedSecret = Preconditions.checkNotNull(sharedSecret);
	}
	
	// @return Returns the account associated with the credentials
	public AccountRequest accountInfo() {
		return new AccountRequest(apiKey, sharedSecret);
	}
	
	// @return Returns the rank sources associated with the account
	public RankSourceListRequest rankSourceList() {
		return new RankSourceListRequest(apiKey, sharedSecret);
	}
	
	// @return Returns the list of locations
	public LocationListRequest locationList() {
		return new LocationListRequest(apiKey, sharedSecret);
	}
	
	// @return Returns the list of devices
	public DeviceListRequest deviceList() {
		return new DeviceListRequest(apiKey, sharedSecret);
	}
	
	// @return Returns the searches associated with each category
	public CategoryListRequest categoryList(String accountId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		
		return new CategoryListRequest(apiKey, sharedSecret, accountId);
	}
	
	// @return Returns the list of web properties for the account
	public WebPropertyListRequest webProperties(String accountId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		
		return new WebPropertyListRequest(apiKey, sharedSecret, accountId);
	}
	
	// @return Returns the list of tracked search objects for the corresponding account and web property
	public TrackedSearchListRequest trackedSearches(String accountId, String webPropertyId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		Preconditions.checkNotNull(webPropertyId, "Web Property Id cannot be null!");

		return new TrackedSearchListRequest(apiKey, sharedSecret, accountId, webPropertyId);
	}
	
	// @return Returns all the search terms for all the tracked searches corresponding to the account, web property and against a rank source
	public ClientWebPropertyRankRequest webPropertyRanks(String accountId, String webPropertyId, String rankSourceId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		Preconditions.checkNotNull(webPropertyId, "Web Property Id cannot be null!");
		Preconditions.checkNotNull(rankSourceId, "Rank Source Id cannot be null!");
		
		return new ClientWebPropertyRankRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId);
	}
	
	// @return Returns all the search terms for all the tracked searches corresponding to the account, web property against a rank source and for the specified time period
	public ClientWebPropertyRankRequest webPropertyRanks(String accountId, String webPropertyId, String rankSourceId, String timePeriodId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		Preconditions.checkNotNull(webPropertyId, "Web Property Id cannot be null!");
		Preconditions.checkNotNull(rankSourceId, "Rank Source Id cannot be null!");

		if(timePeriodId == null)
			return new ClientWebPropertyRankRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId);
		else
			return new ClientWebPropertyRankRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId, timePeriodId);
	}
	
	// @return Returns the monthly volume of searches for all the tracked searches corresponding to the account, web property and against a rank source
	public ClientWebPropertyVolumeRequest webPropertyVolume(String accountId, String webPropertyId, String rankSourceId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		Preconditions.checkNotNull(webPropertyId, "Web Property Id cannot be null!");
		Preconditions.checkNotNull(rankSourceId, "Rank Source Id cannot be null!");
		
		return new ClientWebPropertyVolumeRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId);
	}
	
	// @return Returns the monthly volume of searches for all the tracked searches corresponding to the account, web property and against a rank source and for the specified time period
	public ClientWebPropertyVolumeRequest webPropertyVolume(String accountId, String webPropertyId, String rankSourceId, String timePeriodId) {
		Preconditions.checkNotNull(accountId, "Account Id cannot be null!");
		Preconditions.checkNotNull(webPropertyId, "Web Property Id cannot be null!");
		Preconditions.checkNotNull(rankSourceId, "Rank Source Id cannot be null!");

		if(timePeriodId == null)
			return new ClientWebPropertyVolumeRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId);
		else
			return new ClientWebPropertyVolumeRequest(apiKey, sharedSecret, accountId, webPropertyId, rankSourceId, timePeriodId);
	}
}
