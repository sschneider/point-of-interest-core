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
package de.schneider.dev.poi.model;

/**
 * Creates a GeoCoordinate object is a geographic location determined by the latitude and longitude coordinates.
 * @author Sebastian Schneider
 *
 */
public class GeoCoordinate {

	/**
	 * geographical latitude
	 */
	private double latitude;
	
	/**
	 * geographical longitude
	 */
	private double longitude;
	
	/**
	 * Standard constructor
	 */
	public GeoCoordinate() {
		
	}
	
	/**
	 * Constructor of a GeoCoordinate object consisting of a geographic latitude and a geographic longitude
	 * @param latitude the geographic latitude
	 * @param longitude the geographic longitude
	 */
	public GeoCoordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * 
	 * @param latitude the geographic latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 
	 * @return the geographic latitude of a location
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * 
	 * @param longitude the geographic longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 
	 * @return the geographic longitude of a location
	 */
	public double getLongitude() {
		return longitude;
	}
}
