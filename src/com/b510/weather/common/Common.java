/**
 * 
 */
package com.b510.weather.common;

/**
 * all the constants will be here.
 * 
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class Common {

	public static final String WEATHER = "weather";

	public static final String BLANK = " ";
	public static final String EMPTY = "";
	public static final String DASH = "-";
	public static final String COLOR = ":";
	public static final String DEGREE = "°";
	public static final String COMMA = ",";
	public static final String SLASH = "/";
	public static final String ENCODING_UTF_8 = "UTF-8";
	public static final String DATE_FORMATE_MMSS = "mm:ss";
	public static final String DATE_FORMATE = "dd-MMM-YYYY HH:" + DATE_FORMATE_MMSS;
	public static final String DEFAULT_CITY = "singapore";
	public static final String DEFAULT_TEMP = "0" + DEGREE;
	public static final String YAHOO_WEAHTER_URL = "https://weather.yahoo.com/";
	public static final String YAHOO_WEAHTER_XML_URL = "http://xml.weather.yahoo.com/forecastrss?u=c&w=";
	public static final String WEATHER_ICON_PATH = "/com/b510/weather/resources/images/weather_icon_";
	public static final String WEATHER_ICON_TYPE = ".png";
	public static final String CARRIAGE_RETURN = "\r\n";

	public static final String FONT_TAHOMA = "Tahoma";
	public static final String SEARCH = "Search";
	public static final String VISIBILITY = "Visibility";
	public static final String HUMIDITY = "Humidity";
	public static final String WIND = "Wind";
	public static final String KM = "km";
	public static final String KM_H = KM + SLASH + "h";
	public static final String PERCENT = "%";
	public static final String WEATHER_ROOT_PATH = "c:/weather/";
	public static final String WEATHER_COUNTRY = WEATHER_ROOT_PATH + "weather_country.txt";
	public static final String WEATHER_CODE_PATH = WEATHER_ROOT_PATH + "weather_code.txt";

	public static final char W = 'W';
	public static final char M = 'M';
	
	public static final String FILE = "File";
	public static final String EXIT = "Exit";
	public static final String ADD_COUNTRY = "Add Country";
	public static final String SHOW_CITY = "Show City";
	public static final String ABOUT = "About";
	public static final String COUNTRY = "Country" + BLANK + COLOR;
	public static final String PROVINCE = "Province" + BLANK + COLOR;

	public static final String FILE_NOT_EXIST_MSG = "Can not find file. Please ensure the file exist.";
	public static final String ENCOUNTERED_ERROR = "Encountered error when reading the file.";
	public static final String CAN_NOT_FIND_CITY = "Can not find the city!";
	public static final String TYPE_CITY = "Please type the city name!";
	
	public static final String ABOUT_INFO =
			"<html><head><style>"
			+ "table {"
			+"width:100%;}"
			+"table, td {"
			+"border: 1px solid black;}"
			+ "</style>"
			+ "</head>"
	
			+ "<body>"
			+ "<br>"
				+ "<table id='t01'>"
					+ "<tr>"
				    	+ "<td>Application Name</td>"
				    	+ "<td>" + WEATHER +"</td>"		
				    + "</tr>"
				    + "<tr>"
				    	+ "<td>Version</td>"
				    	+ "<td>1.0</td>"	
				    + "</tr>"
				    + "<tr>"
				    	+ " <td>Author</td>"
				    	+ " <td>Hongten</td>"		
				    + "</tr>"
				    + " <tr>"
				  		+ " <td>Home Page</td>"
				  		+ "<td><a href='http://www.cnblogs.com/hongten' target='_blank'><font color='#880000'><b>http://www.cnblogs.com/hongten</b></font></a></td>"	
				    + "</tr>"
				    + " <tr>"
			  			+ " <td>github</td>"
			  			+ "<td><a href='https://github.com/Hongten' target='_blank'><font color='#880000'><b>https://github.com/Hongten</b></font></a></td>"	
			  		+ "</tr>"
			  		+ " <tr>"
			  			+ " <td>Data From</td>"
			  			+ "<td><a href='https://weather.yahoo.com' target='_blank'><font color='#880000'><b>https://weather.yahoo.com</b></font></a></td>"	
			  		+ "</tr>"
				+ "</table>"

		+ "</body>" + "</html>";

}
