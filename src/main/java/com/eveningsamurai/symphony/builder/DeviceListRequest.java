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

import com.eveningsamurai.symphony.model.DeviceListResponse;
import com.google.gson.reflect.TypeToken;

public class DeviceListRequest extends Request {
	/**
	 * Constructor
	 * 
	 * Create a new request builder for  accounts
	 * @param apiKey the api key to use to access the searchlight conductor api
	 * @param sharedSecret the shared secret to use to access the searchlight conductor api
	 */
	public DeviceListRequest(String apiKey, String sharedSecret) {
		super(apiKey, sharedSecret);
	}
	
	/** Endpoint for location list request api
	 * GET v3/locations
	 * @return devices list url as string
	 */
	@Override
	public String getEndpoint() {
		return "https://api.conductor.com/v3/devices";
	}

	/**
	 * @return gson type
	 */
	@Override
	protected Type getTypeForGson() {
		Type deviceListResponseType = new TypeToken<DeviceListResponse[]>() { }.getType();
		return deviceListResponseType;
	}
}
