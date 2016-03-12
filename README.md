# weather

This application writed by Java luanguage, and the data from [`Yahoo Weather`](https://weather.yahoo.com/).

It provides 22 countries weather infromation. Including the [`Singapore`](https://weather.yahoo.com/finland/singapore/), [`China`](https://weather.yahoo.com/China), [`Japan`](https://weather.yahoo.com/Japan), [`United States`](https://weather.yahoo.com/United-States), [`India`](https://weather.yahoo.com/India), [`South Korea`](https://weather.yahoo.com/South-Korea), [`Indonesia`](https://weather.yahoo.com/Indonesia), [`Malaysia`](https://weather.yahoo.com/Malaysia), [`France`](https://weather.yahoo.com/France), [`Italy`](https://weather.yahoo.com/Italy), [`Canda`](https://weather.yahoo.com/Canda), [`Mexico`](https://weather.yahoo.com/Mexico), [`Colombia`](https://weather.yahoo.com/Colombia), [`Spain`](https://weather.yahoo.com/Spain), [`Poland`](https://weather.yahoo.com/Poland), [`Russia`](https://weather.yahoo.com/Russia), [`Ireland`](https://weather.yahoo.com/Ireland), [`Egypt`](https://weather.yahoo.com/Egypt), [`Libya`](https://weather.yahoo.com/Libya), [`South Africa`](https://weather.yahoo.com/South-Africa), [`Australia`](https://weather.yahoo.com/Australia), [`Philippines`](https://weather.yahoo.com/Philippines),
and it takes up less CPU resources when it running. 

The weather application will update current city weather information once every half hour.

![Example](https://github.com/Hongten/weather/blob/master/image/cpu usage.png)

weather need JDK-1.7 or above.

You can get the runable jar file [`weather.jar`](https://github.com/Hongten/weather/blob/master/jar/weather.jar) (`~2.46MB, Save link as... to download`) to run first.

If you run weather applicaiton first time, you may wait a few minutes to get the city code, because the weather application need to parse XML file from [`Yahoo Weather`](https://weather.yahoo.com/) according to the city code.

After you run first time, the country record will be saved in the `c:/weather/weather_country.txt` file and the city code record will be saved in the `c:/weather/weather_code.txt`. The default city is [`Singapore`](https://weather.yahoo.com/singapore/singapore/singapore-1062617/), because weather was created in `Singapore`.

# Main Panel

The main panel includes `search zone`, `current weather details` and `forcast next three days infromation`.

You can type the city name, and click `Search` button to get the city weather details.

![Example](https://github.com/Hongten/weather/blob/master/image/main_panel.png)

# Show City

`CTRL + M` will open show city panel to show all `countries, provinces, cities`.

![Example](https://github.com/Hongten/weather/blob/master/image/show_city_panel.png)

When you select one city record and double click it, then the weather application will show this city weather detail in the main panel.

If the city(e.g, `imphal, manipur, india`) can not be find, the weather application will inform user as below information.

![Example](https://github.com/Hongten/weather/blob/master/image/can_not_find_city_imphal.png)

![Example](https://github.com/Hongten/weather/blob/master/image/can_not_find_city.png)

# Change Skin Panel

When you click the upper left corner of weather application, you can set `skin`, `theme` and `watermarks` etc.

![Example](https://github.com/Hongten/weather/blob/master/image/change_skin_panel.png)

# About Panel

About panel includes some information about the weather application and author.

![Example](https://github.com/Hongten/weather/blob/master/image/about_panel.png)

# Project Structure

The weather application is a java project, and its structure as below :

![Example](https://github.com/Hongten/weather/blob/master/image/project_structure.png)

> How can we get weather details from the [`Yahoo Weather`](https://weather.yahoo.com/)?

First, we need to know the XML file that the [`Yahoo Weather`](https://weather.yahoo.com/)

e.g, [http://xml.weather.yahoo.com/forecastrss?u=c&w=1062617](http://xml.weather.yahoo.com/forecastrss?u=c&w=1062617), this URL is get the Singapore weather details.
The important thing is city code(**1062617**).

```xml
	<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
		<rss version="2.0" xmlns:yweather="http://xml.weather.yahoo.com/ns/rss/1.0" xmlns:geo="http://www.w3.org/2003/01/geo/wgs84_pos#">
			<channel>
		
<title>Yahoo! Weather - Singapore, SG</title>
<link>http://us.rd.yahoo.com/dailynews/rss/weather/Singapore__SG/*http://weather.yahoo.com/forecast/SNXX0006_c.html</link>
<description>Yahoo! Weather for Singapore, SG</description>
<language>en-us</language>
<lastBuildDate>Sat, 12 Mar 2016 10:58 pm SGT</lastBuildDate>
<ttl>60</ttl>
<yweather:location city="Singapore" region=""   country="Singapore"/>
<yweather:units temperature="C" distance="km" pressure="mb" speed="km/h"/>
<yweather:wind chill="29"   direction="50"   speed="12.87" />
<yweather:atmosphere humidity="79"  visibility="9.99"  pressure="982.05"  rising="1" />
<yweather:astronomy sunrise="7:11 am"   sunset="7:17 pm"/>
<image>
<title>Yahoo! Weather</title>
<width>142</width>
<height>18</height>
<link>http://weather.yahoo.com</link>
<url>http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif</url>
</image>
<item>
<title>Conditions for Singapore, SG at 10:58 pm SGT</title>
<geo:lat>1.29</geo:lat>
<geo:long>103.85</geo:long>
<link>http://us.rd.yahoo.com/dailynews/rss/weather/Singapore__SG/*http://weather.yahoo.com/forecast/SNXX0006_c.html</link>
<pubDate>Sat, 12 Mar 2016 10:58 pm SGT</pubDate>
<yweather:condition  text="Mostly Cloudy"  code="27"  temp="29"  date="Sat, 12 Mar 2016 10:58 pm SGT" />
<description><![CDATA[
<img src="http://l.yimg.com/a/i/us/we/52/27.gif"/><br />
<b>Current Conditions:</b><br />
Mostly Cloudy, 29 C<BR />
<BR /><b>Forecast:</b><BR />
Sat - Partly Cloudy. High: 31 Low: 26<br />
Sun - Thunderstorms. High: 33 Low: 26<br />
Mon - Thunderstorms. High: 33 Low: 26<br />
Tue - Partly Cloudy. High: 34 Low: 26<br />
Wed - Partly Cloudy. High: 34 Low: 26<br />
<br />
<a href="http://us.rd.yahoo.com/dailynews/rss/weather/Singapore__SG/*http://weather.yahoo.com/forecast/SNXX0006_c.html">Full Forecast at Yahoo! Weather</a><BR/><BR/>
(provided by <a href="http://www.weather.com" >The Weather Channel</a>)<br/>
]]></description>
<yweather:forecast day="Sat" date="12 Mar 2016" low="26" high="31" text="Partly Cloudy" code="29" />
<yweather:forecast day="Sun" date="13 Mar 2016" low="26" high="33" text="Thunderstorms" code="4" />
<yweather:forecast day="Mon" date="14 Mar 2016" low="26" high="33" text="Thunderstorms" code="4" />
<yweather:forecast day="Tue" date="15 Mar 2016" low="26" high="34" text="Partly Cloudy" code="30" />
<yweather:forecast day="Wed" date="16 Mar 2016" low="26" high="34" text="Partly Cloudy" code="30" />
<guid isPermaLink="false">SNXX0006_2016_03_16_7_00_SGT</guid>
</item>
</channel>
</rss>

<!-- api67.weather.sg3.yahoo.com Sat Mar 12 08:02:44 PST 2016 -->
```

City name and country name:

```xml
<yweather:location city="Singapore" region="" country="Singapore"/>
```

Wind speed:

```xml
<yweather:wind chill="29" direction="50" speed="12.87"/>
```

Humidity value and visibility value:

```xml
<yweather:atmosphere humidity="79" visibility="9.99" pressure="982.05" rising="1"/>
```

Current temp(temputer), code(weather icon code) and text(weather description):

```xml
<yweather:condition text="Mostly Cloudy" code="27" temp="29" date="Sat, 12 Mar 2016 10:58 pm SGT"/>
```

Forecast:

```xml
<yweather:forecast day="Sat" date="12 Mar 2016" low="26" high="31" text="Partly Cloudy" code="29"/>
<yweather:forecast day="Sun" date="13 Mar 2016" low="26" high="33" text="Thunderstorms" code="4"/>
<yweather:forecast day="Mon" date="14 Mar 2016" low="26" high="33" text="Thunderstorms" code="4"/>
<yweather:forecast day="Tue" date="15 Mar 2016" low="26" high="34" text="Partly Cloudy" code="30"/>
<yweather:forecast day="Wed" date="16 Mar 2016" low="26" high="34" text="Partly Cloudy" code="30"/>
```

Second, if we get the city code, then we can get the city weather detail.

> How can we get the city code?

We go to the [`Yahoo Weather`](https://weather.yahoo.com/) website : [`https://weather.yahoo.com/`](https://weather.yahoo.com/), and type the city name `singapore` and click `Enter`.

Then we can go to [`https://weather.yahoo.com/singapore/singapore/singapore-1062617/`](https://weather.yahoo.com/singapore/singapore/singapore-1062617/), then we get the city code(**1062617**) from URL.

> But...., There are so many cities in the world, How can we get the city code for each city?

We can go to [`https://weather.yahoo.com/singapore/`](https://weather.yahoo.com/singapore/) to find that there are all zones(provinces) of `Singapore`.

e.g, [`Central Singapore`](https://weather.yahoo.com/singapore/central-singapore/), [`North East`](https://weather.yahoo.com/singapore/north-east/), [`North West`](https://weather.yahoo.com/singapore/north-west/), [`South East`](https://weather.yahoo.com/singapore/south-east/)

and we select first one [`Central Singapore`](https://weather.yahoo.com/singapore/central-singapore/) and to find that there are all zones(cities) of `Central Singapore`.

e.g, 

[`Bukit Timah`](https://weather.yahoo.com/singapore/north-west/bukit-timah-24703014/) - URL is [`https://weather.yahoo.com/singapore/north-west/bukit-timah-24703014/`](https://weather.yahoo.com/singapore/north-west/bukit-timah-24703014/)

[`Singapore`](https://weather.yahoo.com/singapore/singapore/singapore-1062617/) - URL is [`https://weather.yahoo.com/singapore/singapore/singapore-1062617/`](https://weather.yahoo.com/singapore/singapore/singapore-1062617/)

We can parse the HTML provided by [`https://weather.yahoo.com/singapore/central-singapore/`](https://weather.yahoo.com/singapore/central-singapore/) to get the city code(**24703014**, **1062617**).

> How to prase the HTML string?

You can see the method `getCodeString()` in the [`WeatherUtil.java`](https://github.com/Hongten/weather/blob/master/src/com/b510/weather/util/WeatherUtil.java).

# More Information

* Author            : Hongten
* E-mail            : [hongtenzone@foxmail.com](mailto:hongtenzone@foxmail.com)
* Home Page         : [http://www.cnblogs.com/hongten](http://www.cnblogs.com/hongten)
* Refer Skin Page   : [http://www.cnblogs.com/hongten/p/hongten_notepad_substance_skins.html](http://www.cnblogs.com/hongten/p/hongten_notepad_substance_skins.html)
* Substance URL     : [https://substance.dev.java.net/](https://substance.dev.java.net/)
* Yahoo Weather     : [https://weather.yahoo.com/](https://weather.yahoo.com/)
