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
 * Service to provide access to Nominatim which is the Geolocation API of
 * OpenStreetMap http://wiki.openstreetmap.org/wiki/Nominatim
 * 
 * @author Sebastian Schneider
 * 
 */
public class OpenStreetMapGeoService {

	private static Logger LOG = LoggerFactory
			.getLogger(OpenStreetMapGeoService.class);

	private final String URI_String = "http://nominatim.openstreetmap.org/search?q=";

	public void getGeoCoordinate(String location) throws EncoderException {

		LOG.info("Start GeoCoordination OpenStreetMap");

		// create default HttpClient
		HttpClient httpClient = new DefaultHttpClient();
		
		// get data from URI
		URLCodec urlCodec = new URLCodec("UTF-8");
		HttpGet httpGet = new HttpGet(URI_String + urlCodec.encode(location) + "&format=json");
		LOG.info("HttpGet: " + httpGet);
		LOG.debug(httpGet.toString());
		LOG.debug("HttpGetURI: " + httpGet.getURI());
		
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
			LOG.error(cpe.getMessage());
		} catch (IOException ioe) {
			LOG.error(ioe.getMessage());
		}
	}
}
