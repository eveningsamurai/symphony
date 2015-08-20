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

import com.eveningsamurai.symphony.model.CategoryListResponse;
import com.google.gson.reflect.TypeToken;


public class CategoryListRequest extends Request {

	/** Account id for the web property id */
	private String accountId;

	/**
	 * Constructor
	 * 
	 * Create a new request builder for client web property volume report
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 * @param accountId the account id for which the category list is required
	 **/
	public CategoryListRequest(String apiKey, String sharedSecret, String accountId) {
		super(apiKey, sharedSecret);
		this.accountId = accountId;
	}
	
	/** Endpoint for category list request api
	 * GET v3/accounts/{accountId}/categories
	 * @return category list request url as string
	 */
	@Override
	public String getEndpoint() {
		return String.format("https://api.conductor.com/v3/accounts/%s/categories", accountId);
	}
	
	/**
	 * @return gson type
	 */
	@Override
	protected Type getTypeForGson() {
		Type categoryListResponseType = new TypeToken<CategoryListResponse[]>() { }.getType();
		return categoryListResponseType;
	}

}
