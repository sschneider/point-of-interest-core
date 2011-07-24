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

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Schneider
 *
 */
public class GoogleMapGeoServiceTest {

	@Ignore("Not Ready to Run!")
	@Test
	public void testgetGeoCoordinate() {
		
	}
	
	@Test
	public void testGetGeoCoordinate() throws Exception {
		GoogleMapGeoService googleMapGeoService = new GoogleMapGeoService();
		googleMapGeoService.getGeoCoordinate("1600 Amphitheatre Parkway, Mountain View, CA");
	}

}
