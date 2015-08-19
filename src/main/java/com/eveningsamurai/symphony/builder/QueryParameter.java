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

public class QueryParameter {
	/** name and value of the parameter */
	private final String paramName, paramValue;
	
	/** 
	 * Constructor
	 * 
	 * Constructs a new QueryParameter
	 * @param paramName : name of the parameter
	 * @param paramValue: value of the parameter 
	 */
	public QueryParameter(String paramName, String paramValue) {
		this.paramName = paramName;
		this.paramValue = paramValue;
	}
		
	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @return the paramValue
	 */
	public String getParamvalue() {
		return paramValue;
	}
	
	/**
	 * @return QueryParameter as a string 
	 */
	@Override
	public String toString() {
		return String.format("%s=%s", paramName, paramValue);
	}
	
}
