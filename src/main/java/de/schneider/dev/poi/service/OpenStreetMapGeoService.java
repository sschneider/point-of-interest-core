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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service to provide access to Nominatim which is the Geolocation API of OpenStreetMap
 * http://wiki.openstreetmap.org/wiki/Nominatim
 * @author Sebastian Schneider
 *
 */
public class OpenStreetMapGeoService {

	private static Logger LOG = LoggerFactory.getLogger(OpenStreetMapGeoService.class);
	
	private final String URI = "http://nominatim.openstreetmap.org/search"; 
}