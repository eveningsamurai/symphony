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

public class RankSourceListResponse implements Response{

	/** baseDomain: base search engine for the rank source */
	@SerializedName("baseDomain")
	private String baseDomain;
	
	/** description: description of the rank source */
	@SerializedName("description")
	private String description;
	
	/** rankSourceId: id for the rank source */
	@SerializedName("rankSourceId")
	private String rankSourceId;
	
	/** name: name for the rank source */
	@SerializedName("name")
	private String name;

	/**
	 * @return the baseDomain
	 */
	public String getBaseDomain() {
		return baseDomain;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the rankSourceId
	 */
	public String getRankSourceId() {
		return rankSourceId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
