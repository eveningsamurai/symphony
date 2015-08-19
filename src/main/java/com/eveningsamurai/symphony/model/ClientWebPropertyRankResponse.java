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

public class ClientWebPropertyRankResponse implements Response {

	public enum ItemType { STANDARD_LINK, IMAGE_LINK, VIDEO_RESULT, IN_DEPTH_ARTICLES, NEWS_RESULT, LOCAL_RESULT, ANSWER_BOX };
	
	/** webPropertyId: id for the web property associated with the account */
	@SerializedName("webPropertyId")
	private String webPropertyId;

	/** trackedSearchId: id for the tracked search term */
	@SerializedName("trackedSearchId")
	private String trackedSearchId;

	/** itemType: type of the search result */
	@SerializedName("itemType")
	private ItemType itemType;
	
	/** target: target of the search result */
	@SerializedName("target")
	private String target;
	
	/** targetDomainName: domain name for the search result url */
	@SerializedName("targetDomainName")
	private String targetDomainName;
	
	/** targetUrl: the complete search result url */
	@SerializedName("targetUrl")
	private String targetUrl;
	
	/** ranks: the ranks from the rank source corresponding to the tracked search id */
	@SerializedName("ranks")
	private Ranks ranks;
	
	/**
	 * @return the webPropertyId
	 */
	public String getWebPropertyId() {
		return webPropertyId;
	}

	/**
	 * @return the trackedSearchId
	 */
	public String getTrackedSearchId() {
		return trackedSearchId;
	}

	/**
	 * @return the itemType
	 */
	public ItemType getItemType() {
		return itemType;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @return the targetDomainName
	 */
	public String getTargetDomainName() {
		return targetDomainName;
	}

	/**
	 * @return the targetUrl
	 */
	public String getTargetUrl() {
		return targetUrl;
	}

	/**
	 * @return the ranks
	 */
	public Ranks getRanks() {
		return ranks;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	public static class Ranks {
		/** universalRank: */
		@SerializedName("UNIVERSAL_RANK")
		private String universalRank;
		
		/** trueRank: */
		@SerializedName("TRUE_RANK")
		private String trueRank;
		
		/** classicRank: */
		@SerializedName("CLASSIC_RANK")
		private String classicRank;

		/**
		 * @return the universalRank
		 */
		public String getUniversalRank() {
			return universalRank;
		}

		/**
		 * @return the trueRank
		 */
		public String getTrueRank() {
			return trueRank;
		}

		/**
		 * @return the classicRank
		 */
		public String getClassicRank() {
			return classicRank;
		}
		
		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
	}
}
