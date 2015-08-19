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

import com.google.gson.annotations.SerializedName;

public class WebPropertyListResponse implements Response {
	/** isActive: boolean for if account is active  */
	@SerializedName("isActive")
	private boolean isActive;
	
	/** webPropertyId: id for the web property associated with the account */
	@SerializedName("webPropertyId")
	private String webPropertyId;
	
	/** trackedSearchList: url for tracked searches for the webPropertyId */
	@SerializedName("trackedSearchList")
	private String trackedSearchList;
	
	/** name: name of the web property */
	@SerializedName("name")
	private String name;
	
	/** rankSourceInfo: array of rank source info */
	@SerializedName("rankSourceInfo")
	private RankSourceInfo[] rankSourceInfo;
	
	public static class RankSourceInfo {
		/** rankSourceId: the search engine being referenced */
		@SerializedName("rankSourceId")
		private String rankSourceId;
		
		/** reports: reports for the rank source */
		@SerializedName("reports")
		private Reports reports;
		
		public static class Reports {
			/** CURRENT: current report for the rank source */
			@SerializedName("CURRENT")
			private Current current;
			
			public static class Current {
				/** startDate: start date for the metric collection */
				@SerializedName("startDate")
				private String startDate;
				
				/** endDate: end date for the metric collection */
				@SerializedName("endDate")
				private String endDate;
				
				/** webPropertySearchVolumeReport: url for volume report */
				@SerializedName("webPropertySearchVolumeReport")
				private String webPropertySearchVolumeReport;
				
				/** webPropertyRankReport: url for rank report */
				@SerializedName("webPropertyRankReport")
				private String webPropertyRankReport;
				
				/** timePeriodId: time period id */
				@SerializedName("timePeriodId")
				private String timePeriodId;

				/**
				 * @return the startDate
				 */
				public String getStartDate() {
					return startDate;
				}

				/**
				 * @return the endDate
				 */
				public String getEndDate() {
					return endDate;
				}

				/**
				 * @return the webPropertySearchVolumeReport
				 */
				public String getWebPropertySearchVolumeReport() {
					return webPropertySearchVolumeReport;
				}

				/**
				 * @return the webPropertyRankReport
				 */
				public String getWebPropertyRankReport() {
					return webPropertyRankReport;
				}

				/**
				 * @return the timePeriodId
				 */
				public String getTimePeriodId() {
					return timePeriodId;
				}
			}

			/**
			 * @return the current
			 */
			public Current getCurrent() {
				return current;
			}
			
		}
	
		/** comparisonWebProperties: web properties to be compared against */
		@SerializedName("comparisonWebProperties")
		private ComparisonWebProperty[] comparisonWebProperties;
		
		public static class ComparisonWebProperty {
			/** label:  label for the comparison web property */
			@SerializedName("label")
			private String label;
			
			/** name: name for the comparison web property */
			@SerializedName("name")
			private String name;
			
			/** webPropertyId: id for the comparison web property */
			@SerializedName("webPropertyId")
			private String webPropertyId;

			/**
			 * @return the label
			 */
			public String getLabel() {
				return label;
			}

			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * @return the webPropertyId
			 */
			public String getWebPropertyId() {
				return webPropertyId;
			}
		}

		/**
		 * @return the rankSourceId
		 */
		public String getRankSourceId() {
			return rankSourceId;
		}

		/**
		 * @return the reports
		 */
		public Reports getReports() {
			return reports;
		}

		/**
		 * @return the comparisonWebProperties
		 */
		public ComparisonWebProperty[] getComparisonWebProperties() {
			return comparisonWebProperties;
		}
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @return the webPropertyId
	 */
	public String getWebPropertyId() {
		return webPropertyId;
	}

	/**
	 * @return the trackedSearchList
	 */
	public String getTrackedSearchList() {
		return trackedSearchList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rankSourceInfo
	 */
	public RankSourceInfo[] getRankSourceInfo() {
		return rankSourceInfo;
	}	
}
