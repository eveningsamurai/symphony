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

public class ClientWebPropertyVolumeResponse implements Response{
	/** averageVolume: average volume for the tracked search over the time period */
	@SerializedName("averageVolume")
	private Long averageVolume;

	/** trackedSearchId: id for the tracked search term */
	@SerializedName("trackedSearchId")
	private String trackedSearchId;
	
	/** volumeItems: volume for the tracked search term per month of the year */
	@SerializedName("volumeItems")
	private VolumeItem[] volumeItems;

	/**
	 * @return the averageVolume
	 */
	public Long getAverageVolume() {
		return averageVolume;
	}

	/**
	 * @return the trackedSearchId
	 */
	public String getTrackedSearchId() {
		return trackedSearchId;
	}

	/**
	 * @return the volumeItems
	 */
	public VolumeItem[] getVolumeItems() {
		return volumeItems;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	public static class VolumeItem {
		/** volume: volume for the month */
		@SerializedName("volume")
		private Long volume;
		
		/** month: month for the volume metric */
		@SerializedName("month")
		private Long month;
		
		/** year: year for the volume metric */
		@SerializedName("year")
		private Integer year;

		/**
		 * @return the volume
		 */
		public Long getVolume() {
			return volume;
		}

		/**
		 * @return the month
		 */
		public Long getMonth() {
			return month;
		}

		/**
		 * @return the year
		 */
		public Integer getYear() {
			return year;
		}
		
		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
		
	}
}
