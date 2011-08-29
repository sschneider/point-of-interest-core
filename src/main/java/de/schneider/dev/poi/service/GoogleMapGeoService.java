/**
 * Copyright (c) 2011, Sebastian Schneider
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.schneider.dev.poi.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service to provide access to the Google Geocoding API (v3)
 * http://code.google.com/apis/maps/documentation/geocoding/
 * 
 * @author Sebastian Schneider
 *
 */
public class GoogleMapGeoService {

	private static Logger LOG = LoggerFactory.getLogger(GoogleMapGeoService.class);
	
	private final static String DEFAULT_JSON_URI = "http://maps.googleapis.com/maps/api/geocode/json?address=";
	
	private final static String DEFAULT_XML_URI = "http://maps.googleapis.com/maps/api/geocode/xml?address=";
	
	public void getGeoCoordinate(String location) throws EncoderException {
		
		LOG.info("Start GeoCoordination Google Map");
		
		// create default HttpClient
		HttpClient httpClient = new DefaultHttpClient();
		
		// get data from URI
		URLCodec urlCodec = new URLCodec("UTF-8");
		HttpGet httpGet = new HttpGet(DEFAULT_JSON_URI + urlCodec.encode(location) + "&sensor=false");
		LOG.info("HttpGet: " + httpGet);
		
		// get response
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			LOG.info("HttpResponse: " + httpResponse);
			LOG.info("Status Code: " + httpResponse.getStatusLine().getStatusCode());
			LOG.info("Status Phrase: " + httpResponse.getStatusLine().getReasonPhrase());
			
			HttpEntity httpEntity = httpResponse.getEntity();
			LOG.info("HttpEntity: " + httpEntity);
			LOG.info("HttpEntity Streaming: " + httpEntity.isStreaming());
			if (httpEntity.isStreaming()) {
				InputStream inputStream = httpEntity.getContent();
				String content = EntityUtils.toString(httpEntity);
				LOG.info(content);
				inputStream.close();				
			}
			
		} catch (ClientProtocolException cpe) {
			LOG.error(cpe.toString());
		} catch (IOException ioe) {
			LOG.error(ioe.toString());
		}
	}
}
