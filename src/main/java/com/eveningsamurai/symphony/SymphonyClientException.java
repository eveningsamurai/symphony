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

public class SymphonyClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8331797261791184910L;

	/** Construct a new RequestBuilderException */
	public SymphonyClientException() {
		super();
	}
	
	/**
	 * Construct a new RequestBuilderException
	 * @param cause the Cause
	 */
	public SymphonyClientException(Throwable cause) {
		super(cause);
	}
}
