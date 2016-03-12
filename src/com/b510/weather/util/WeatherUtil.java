/**
 * 
 */
package com.b510.weather.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.b510.weather.common.Common;
import com.b510.weather.ui.MainUI;
import com.b510.weather.vo.WeatherVO;

/**
 * @author Hongten
 * @created 11 Mar, 2016
 */
public class WeatherUtil {

	static Logger logger = Logger.getLogger(WeatherUtil.class);

	private URLConnection connectionData;
	private StringBuilder sb;
	private BufferedReader br;
	static List<WeatherVO> weatherVOs;
	static WeatherVO weatherVO;
	static StringBuffer cityCodeBuffer = new StringBuffer();
	public static List<String> countryList = new ArrayList<String>();

	/**
	 * search weather by city name
	 * @param cityName city name
	 * @param cityMap
	 * @return {@link com.b510.weather.vo.WeatherVO WeatherVO}
	 * @throws Exception
	 */
	public static WeatherVO searchWeather(String cityName, Map<String, String> cityMap) throws Exception {
		weatherVO = null;
		weatherVO = new WeatherVO();
		WeatherUtil util = new WeatherUtil();
		for (Map.Entry<String, String> entry : cityMap.entrySet()) {
			if (entry.getValue().equals(cityName)) {
				String[] keys = entry.getKey().split(Common.COLOR);
				weatherVO.setProvince(keys[0]);
				String xmlUrl = Common.YAHOO_WEAHTER_XML_URL + keys[1];
				String xmlContent = util.getCodeString(xmlUrl, true);

				BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(xmlContent.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
				String line;
				boolean todayForecast = true;
				// remove old record.
				if (weatherVOs != null) {
					weatherVOs = null;
				}
				weatherVOs = new ArrayList<WeatherVO>();
				while ((line = br.readLine()) != null) {
					if (line.startsWith("<yweather:location")) {
						// <yweather:location city="New York" region="NY" country="United States"/>
						String[] citys = line.split("city=\"");
						String city = citys[1].substring(0, citys[1].indexOf("\""));
						logger.debug(city);
						weatherVO.setCity(city);
						String[] countrys = line.split("country=\"");
						String country = countrys[1].substring(0, countrys[1].indexOf("\""));
						logger.debug(country);
						weatherVO.setCountry(country);
						weatherVO.setCityCode(entry.getKey());
					} else if (line.startsWith("<yweather:wind")) {
						// <yweather:wind chill="-2" direction="0" speed="11.27"/>
						String[] directions = line.split("direction=\"");
						String direction = directions[1].substring(0, directions[1].indexOf("\""));
						logger.debug(direction);
						weatherVO.setDirection(direction);
						String[] windSpeeds = line.split("speed=\"");
						String windSpeed = windSpeeds[1].substring(0, windSpeeds[1].indexOf("\""));
						logger.debug(windSpeed);
						weatherVO.setWindSpeed(windSpeed);
					} else if (line.startsWith("<yweather:atmosphere")) {
						// <yweather:atmosphere humidity="48" visibility="16.09" pressure="1017.5" rising="1"/>
						String[] humiditys = line.split("humidity=\"");
						String humidity = humiditys[1].substring(0, humiditys[1].indexOf("\""));
						logger.debug(humidity);
						weatherVO.setHumidity(humidity);
						String[] visibilitys = line.split("visibility=\"");
						String visibility = visibilitys[1].substring(0, visibilitys[1].indexOf("\""));
						logger.debug(visibility);
						weatherVO.setVisibility(visibility);
					} else if (line.startsWith("<yweather:condition")) {
						// <yweather:condition text="Fair" code="33" temp="2" date="Fri, 04 Mar 2016 8:50 pm EST"/>
						String[] texts = line.split("text=\"");
						String text = texts[1].substring(0, texts[1].indexOf("\""));
						logger.debug(text);
						weatherVO.setText(text);
						String[] codes = line.split("code=\"");
						String code = codes[1].substring(0, codes[1].indexOf("\""));
						logger.debug(code);
						weatherVO.setCode(code);
						String[] temps = line.split("temp=\"");
						String temp = temps[1].substring(0, temps[1].indexOf("\""));
						logger.debug(temp);
						weatherVO.setTemp(temp);
					} else if (line.startsWith("<yweather:forecast")) {
						// <yweather:forecast day="Sat" date="5 Mar 2016" low="11" high="24" text="Partly Cloudy" code="30"/>
						if (todayForecast) {
							String[] lows = line.split("low=\"");
							String low = lows[1].substring(0, lows[1].indexOf("\""));
							logger.debug(low);
							weatherVO.setLow(low);
							String[] highs = line.split("high=\"");
							String high = highs[1].substring(0, highs[1].indexOf("\""));
							logger.debug(high);
							weatherVO.setHigh(high);
							todayForecast = false;
						} else {
							WeatherVO vo = new WeatherVO();
							String[] days = line.split("day=\"");
							String day = days[1].substring(0, days[1].indexOf("\""));
							logger.debug(day);
							vo.setDay(day);
							String[] dates = line.split("date=\"");
							String date = dates[1].substring(0, dates[1].indexOf("\""));
							logger.debug(date);
							vo.setDate(date);
							String[] lows = line.split("low=\"");
							String low = lows[1].substring(0, lows[1].indexOf("\""));
							logger.debug(low);
							vo.setLow(low);
							String[] highs = line.split("high=\"");
							String high = highs[1].substring(0, highs[1].indexOf("\""));
							logger.debug(high);
							vo.setHigh(high);
							String[] texts = line.split("text=\"");
							String text = texts[1].substring(0, texts[1].indexOf("\""));
							logger.debug(text);
							vo.setText(text);
							String[] codes = line.split("code=\"");
							String code = codes[1].substring(0, codes[1].indexOf("\""));
							logger.debug(code);
							vo.setCode(code);
							weatherVOs.add(vo);
						}
					}
				}
				weatherVO.setWeatherVOs(weatherVOs);

				// ======================================================
				// ==== for testing
				// ======================================================
				if (weatherVO != null) {
					logger.debug("=========================================");
					logger.debug("City : " + weatherVO.getCity() + " Country : " + weatherVO.getCountry() + " CountryCode : " + weatherVO.getCityCode());
					logger.debug("Wind Speed : " + weatherVO.getWindSpeed() + "km  Direction : " + weatherVO.getDirection());
					logger.debug("humidity : " + weatherVO.getHumidity() + "% visibility : " + weatherVO.getVisibility() + "km");
					logger.debug("text : " + weatherVO.getText() + " code : " + weatherVO.getCode() + " temp : " + weatherVO.getTemp() + "c Low : " + weatherVO.getLow() + "c High : " + weatherVO.getHigh());
					if (weatherVO.getWeatherVOs() != null && weatherVO.getWeatherVOs().size() > 0) {
						for (WeatherVO vo : weatherVO.getWeatherVOs()) {
							logger.debug("day : " + vo.getDay() + "text : " + vo.getText() + " code : " + vo.getCode() + " date : " + vo.getDate() + "c Low : " + vo.getLow() + "c High : " + vo.getHigh());
						}
					}
					logger.debug("=========================================");
				}
			}
		}
		return weatherVO;
	}

	/**
	 * according the URL to get the string
	 * @param urlStr url string
	 * @param isXmlUrl the flag to check if it calls XML url, if <code>true</code>, return the XML string.
	 * @return according the URL to get the string
	 * @throws Exception
	 */
	public String getCodeString(String urlStr, boolean isXmlUrl) throws Exception {
		String codeStr = "";
		URL url = new URL(urlStr);
		connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		try {
			br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(), Common.ENCODING_UTF_8));
			sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + Common.CARRIAGE_RETURN);
				if (!isXmlUrl) {
					if (line.contains("Weather Forecasts</h1>")) {
						codeStr = line;
					}
				}
			}
			if (isXmlUrl) {
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codeStr;
	}

	/**
	 * load city map. There are two method to load city map :<br>
	 * <li>Fist : load city map from local. The default method for this one, if
	 * can not find any local record, then will be choice the other method</li>
	 * <li>Second : load city map from <a
	 * href="https://weather.yahoo.com/">Yahoo Weather</a> website</li>
	 */
	public void loadCityMap() throws Exception {
		// cityMap -- malaysia:pahang:pekan:1155006
		File rootFile = new File(Common.WEATHER_ROOT_PATH);
		if (!rootFile.exists()) {
			logger.debug("creating folder : " + Common.WEATHER_ROOT_PATH);
			rootFile.mkdir();
		}
		List<String> records = null;
		records = ReaderUtil.reader(Common.WEATHER_CODE_PATH);
		if (records != null && records.size() > 0) {
			logger.debug("loading local records from : " + Common.WEATHER_CODE_PATH);
			for (String record : records) {
				String[] strs = record.split(Common.COLOR);
				String province = strs[strs.length - 3];
				String city = strs[strs.length - 2];
				String code = strs[strs.length - 1];
				MainUI.cityMap.put(province + Common.COLOR + code, city);
			}
		} else {
			logger.debug("loading online records.");
			loadCountries();
			if (countryList != null || countryList.size() >= 0) {
				for (String country : countryList) {
					logger.debug("loading " + country);
					String provinceStr = getCodeString(Common.YAHOO_WEAHTER_URL + country + Common.SLASH, false);
					List<String> provinces = getProvinces(provinceStr, country);
					// get all provinces
					for (String province : provinces) {
						logger.debug(province);
						String url = Common.YAHOO_WEAHTER_URL + country + Common.SLASH + province + Common.SLASH;
						String cityStr = getCodeString(url, false);
						getCity(cityStr, province, country);
					}
				}
				// write city code into file.
				WriterUtil.write(Common.WEATHER_CODE_PATH, cityCodeBuffer.substring(0, cityCodeBuffer.length() - 2).toString());
			} else {
				logger.debug("can not find country! Please check the file : " + Common.WEATHER_COUNTRY);
			}
		}
		logger.debug("load city map done.");
	}

	/**
	 *  get all provinces for country
	 * @param provinceStr the string include the province name of country
	 * @param country country name
	 * @return
	 */
	private static List<String> getProvinces(String provinceStr, String country) {
		List<String> provinces = new ArrayList<String>();
		String[] proStr = provinceStr.split("<a href=\"/" + country + Common.SLASH);
		if (proStr != null && proStr.length > 0) {
			for (int i = 1; i < proStr.length; i++) {
				provinces.add(proStr[i].split("/")[0]);
			}
		}
		return provinces;
	}

	/**
	 * get all cities
	 * @param cityStr the string include the city name of province in the county
	 * @param province province name
	 * @param country country name
	 */
	private static void getCity(String cityStr, String province, String country) {
		logger.debug("city :  --> <a href=\"/" + country + "/" + province + "/");

		String[] cityStrs = cityStr.split("<a href=\"/" + country + Common.SLASH + province + Common.SLASH);
		singaporeSpecial(province, country);

		if (cityStrs != null && cityStrs.length > 0) {
			for (int i = 1; i < cityStrs.length; i++) {
				// shengxian-2132610
				String[] cityMapValues = cityStrs[i].split(Common.SLASH)[0].split(Common.DASH);
				if (cityMapValues != null && cityMapValues.length > 2) {
					logger.debug(country + ":" + province + ":" + getCityName(cityMapValues) + ":" + cityMapValues[cityMapValues.length - 1]);
					MainUI.cityMap.put(province + Common.COLOR + cityMapValues[cityMapValues.length - 1], getCityName(cityMapValues));
					cityCodeBuffer.append(country + Common.COLOR + province + Common.COLOR + getCityName(cityMapValues) + Common.COLOR + cityMapValues[cityMapValues.length - 1] + Common.CARRIAGE_RETURN);
				} else {
					logger.debug(country + ":" + province + ":" + cityMapValues[0] + ":" + cityMapValues[1]);
					MainUI.cityMap.put(province + Common.COLOR + cityMapValues[1], cityMapValues[0]);
					cityCodeBuffer.append(country + Common.COLOR + province + Common.COLOR + cityMapValues[0] + Common.COLOR + cityMapValues[1] + Common.CARRIAGE_RETURN);
				}
			}
		}
	}

	/**
	 * there are two special recored for singapore.
	 * @param province province name
	 * @param country country name
	 */
	private static void singaporeSpecial(String province, String country) {
		if ("singapore".equals(country)) {
			logger.debug("there are two special recored for singapore.");
			MainUI.cityMap.put(province + ":24703014", "bukit-timah");
			cityCodeBuffer.append("singapore:north-west:bukit-timah:24703014" + Common.CARRIAGE_RETURN);
			logger.debug("singapore:north-west:bukit-timah:24703014");
			MainUI.cityMap.put(province + ":1062617", "singapore");
			cityCodeBuffer.append("singapore:singapore:singapore:1062617" + Common.CARRIAGE_RETURN);
			logger.debug("singapore:singapore:singapore:1062617");
		}
	}

	/**
	 * @return the string like 'saint-john-island'
	 */
	private static String getCityName(String[] cityMapValues) {
		String name = "";
		if (cityMapValues != null && cityMapValues.length > 1) {
			for (int i = 0; i < cityMapValues.length - 1; i++) {
				name += cityMapValues[i] + Common.DASH;
			}
			if (name != null && name.length() > 0) {
				name = name.substring(0, name.length() - 1);
			}
		}
		return name;
	}

	/**
	 * load countries, the default countries as below:<br>
	 * china, singapore, japan, united-states, india, south-korea, indonesia, malaysia, france, italy
	 * canada, mexico, colombia, spain, poland,  russia, ireland, egypt, libya,
	 * south-africa, australia
	 */
	public static List<String> loadCountries() {
		File file = new File(Common.WEATHER_COUNTRY);
		StringBuffer countriesSB = new StringBuffer();
		if (!file.exists()) {
			// the default countries as below.
			countriesSB.append("china" + Common.CARRIAGE_RETURN);
			countriesSB.append("singapore" + Common.CARRIAGE_RETURN);
			countriesSB.append("japan" + Common.CARRIAGE_RETURN);
			countriesSB.append("united-states" + Common.CARRIAGE_RETURN);
			countriesSB.append("india" + Common.CARRIAGE_RETURN);
			countriesSB.append("south-korea" + Common.CARRIAGE_RETURN);
			countriesSB.append("indonesia" + Common.CARRIAGE_RETURN);
			countriesSB.append("malaysia" + Common.CARRIAGE_RETURN);
			countriesSB.append("france" + Common.CARRIAGE_RETURN);
			countriesSB.append("italy" + Common.CARRIAGE_RETURN);
			countriesSB.append("canada" + Common.CARRIAGE_RETURN);
			countriesSB.append("mexico" + Common.CARRIAGE_RETURN);
			countriesSB.append("colombia" + Common.CARRIAGE_RETURN);
			countriesSB.append("spain" + Common.CARRIAGE_RETURN);
			countriesSB.append("poland" + Common.CARRIAGE_RETURN);
			countriesSB.append("russia" + Common.CARRIAGE_RETURN);
			countriesSB.append("ireland" + Common.CARRIAGE_RETURN);
			countriesSB.append("egypt" + Common.CARRIAGE_RETURN);
			countriesSB.append("libya" + Common.CARRIAGE_RETURN);
			countriesSB.append("south-africa" + Common.CARRIAGE_RETURN);
			countriesSB.append("australia" + Common.CARRIAGE_RETURN);
			countriesSB.append("philippines" + Common.CARRIAGE_RETURN);
			WriterUtil.write(Common.WEATHER_COUNTRY, countriesSB.substring(0, countriesSB.length() - 2).toString());
		}
		countryList = null;
		countryList = ReaderUtil.reader(Common.WEATHER_COUNTRY);
		return countryList;
	}
}
