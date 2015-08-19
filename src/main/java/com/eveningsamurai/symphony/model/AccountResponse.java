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

public class AccountResponse implements Response {
	
	/** isActive: boolean for if account is active  */
	@SerializedName("isActive")
	private boolean isActive;
	
	/** accountId: id for the account in conductor */
	@SerializedName("accountId")
	private String accountId;
	
	/** webProperties: url for web properties associated with the account */
	@SerializedName("webProperties")
	private String webProperties;
	
	/** name: name on the account */
	@SerializedName("name")
	private String name;

	/**
	 * @return the isActive
	 */
	public boolean isActive() { return isActive; }

	/**
	 * @return the accountId
	 */
	public String getAccountId() { return accountId; }

	/**
	 * @return the webProperties
	 */
	public String getWebProperties() { return webProperties; }

	/**
	 * @return the name
	 */
	public String getName() { return name; }
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
