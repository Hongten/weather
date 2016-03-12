/**
 * 
 */
package com.b510.weather.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class WeatherVO {

	private String country;
	private String province;
	private String city;
	private String cityCode;
	private String visibility;
	private String humidity;
	private String windSpeed;
	private String direction;
	private String temp;
	private String high;
	private String low;
	private String day;
	private String text;
	private String date;
	private String code;
	// for forecast
	List<WeatherVO> weatherVOs = new ArrayList<WeatherVO>();

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<WeatherVO> getWeatherVOs() {
		return weatherVOs;
	}

	public void setWeatherVOs(List<WeatherVO> weatherVOs) {
		this.weatherVOs = weatherVOs;
	}
}
