/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson.stream;

/**
 * A structure, name or value type in a JSON-encoded string.
 *
 * @author Jesse Wilson
 * @since 1.6
 */
public enum JsonToken {


	/**
	 * The opening of a JSON array. Written using {@link JsonWriter#beginArray}
	 * and read using {@link JsonReader#beginArray}.
	 */
	BEGIN_ARRAY(3),

	/**
	 * The closing of a JSON array. Written using {@link JsonWriter#endArray}
	 * and read using {@link JsonReader#endArray}.
	 */
	END_ARRAY(4),

	/**
	 * The opening of a JSON object. Written using {@link JsonWriter#beginObject}
	 * and read using {@link JsonReader#beginObject}.
	 */
	BEGIN_OBJECT(1),

	/**
	 * The closing of a JSON object. Written using {@link JsonWriter#endObject}
	 * and read using {@link JsonReader#endObject}.
	 */
	END_OBJECT(2),

	/**
	 * A JSON property name. Within objects, tokens alternate between names and
	 * their values. Written using {@link JsonWriter#name} and read using {@link
	 * JsonReader#nextName}
	 */
	NAME(12), // 12, 13 et 14

	/**
	 * A JSON string.
	 */
	STRING(8), // 8, 9, 10 et 11

	/**
	 * A JSON number represented in this API by a Java {@code double}, {@code
	 * long}, or {@code int}.
	 */
	NUMBER(15), //15 et 16

	/**
	 * A JSON {@code true} or {@code false}.
	 */
	BOOLEAN(5), // 5 et 6

	/**
	 * A JSON {@code null}.
	 */
	NULL(7),

	/**
	 * The end of the JSON stream. This sentinel value is returned by {@link
	 * JsonReader#peek()} to signal that the JSON-encoded value has no more
	 * tokens.
	 */
	END_DOCUMENT(17);

	private final int givenToken;

	private JsonToken(int givenToken) {
		this.givenToken = givenToken;
	}

	public int toInt() {
		return givenToken;
	}

	public static JsonToken getJsonToken(int token) {
		switch(token) {
			case 1 : return BEGIN_OBJECT;
			case 2 : return END_OBJECT;
			case 3 : return BEGIN_ARRAY;
			case 4 : return END_ARRAY;
			case 5 :
			case 6 :
				return BOOLEAN;
			case 7 : return NULL;
			case 8:
			case 9 :
			case 10 :
			case 11 :
				return STRING;
			case 12 :
			case 13 :
			case 14 :
				return NAME;
			case 15 :
			case 16 :
				return NUMBER;
			case 17 : return END_DOCUMENT;
			default : throw new AssertionError();
		}
	}



}
