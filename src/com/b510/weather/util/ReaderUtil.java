package com.b510.weather.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.b510.weather.common.Common;

/**
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class ReaderUtil {

	static Logger logger = Logger.getLogger(ReaderUtil.class);
	
	/**
	 * @param filePath file path
	 * @return you want to compression file list.
	 */
	public static List<String> reader(String filePath) {
		logger.info("reading : " + filePath);
		List<String> contentList = new ArrayList<String>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), Common.ENCODING_UTF_8);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					lineTxt = lineTxt.replace("\\", "/");
					contentList.add(lineTxt);
				}
				read.close();
			} else {
				logger.debug(Common.FILE_NOT_EXIST_MSG);
			}
		} catch (Exception e) {
			logger.debug(Common.ENCOUNTERED_ERROR);
			e.printStackTrace();
		}
		return contentList;
	}
	
	public static List<String> reader(String filePath, String countryName) {
		logger.info("reading : " + filePath);
		List<String> contentList = new ArrayList<String>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), Common.ENCODING_UTF_8);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// singapore:north-west:bukit-timah:24703014
					if (lineTxt.startsWith(countryName)) {
						contentList.add(lineTxt);
					}
				}
				read.close();
			} else {
				logger.debug(Common.FILE_NOT_EXIST_MSG);
			}
		} catch (Exception e) {
			logger.debug(Common.ENCOUNTERED_ERROR);
			e.printStackTrace();
		}
		return contentList;
	}
}
