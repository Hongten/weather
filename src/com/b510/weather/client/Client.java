/**
 * 
 */
package com.b510.weather.client;

import com.b510.weather.common.Common;
import com.b510.weather.ui.WeatherUI;

/**
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class Client {

	public static void main(String[] args) {
		WeatherUI weatherUI = new WeatherUI(Common.WEATHER);
		weatherUI.init();
	}
}
