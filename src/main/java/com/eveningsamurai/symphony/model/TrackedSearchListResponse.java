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

package com.eveningsamurai.symphony.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TrackedSearchListResponse implements Response {
	/** isActive: boolean for if account is active  */
	@SerializedName("isActive")
	private boolean isActive;
	
	/** trackedSearchId: id for the tracked search term */
	@SerializedName("trackedSearchId")
	private String trackedSearchId;
	
	/** preferredUrl: url configured as the preferred landing page */
	@SerializedName("preferredUrl")
	private String preferredUrl;
	
	/** queryPhrase: query phrase associated with the tracked search id*/
	@SerializedName("queryPhrase")
	private String queryPhrase;
	
	/** locationId: id corresponding to the location associated with the tracked search id */
	@SerializedName("locationId")
	private String locationId;
	
	/** rankSourceId: id corresponding to the rank source associated with the tracked search id */
	@SerializedName("rankSourceId")
	private String rankSourceId;
	
	/** deviceId: id corresponding to the device associated with the tracked search id */
	@SerializedName("deviceId")
	private String deviceId;

	/**
	 * @return the isActive flag
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @return the trackedSearchId
	 */
	public String getTrackedSearchId() {
		return trackedSearchId;
	}

	/**
	 * @return the preferredUrl
	 */
	public String getPreferredUrl() {
		return preferredUrl;
	}

	/**
	 * @return the queryPhrase
	 */
	public String getQueryPhrase() {
		return queryPhrase;
	}

	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * @return the rankSourceId
	 */
	public String getRankSourceId() {
		return rankSourceId;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
