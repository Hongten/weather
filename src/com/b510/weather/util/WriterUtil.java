/**
 * 
 */
package com.b510.weather.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Hongten
 * @created 11 Mar, 2016
 */
public class WriterUtil {

	static Logger logger = Logger.getLogger(WriterUtil.class);

	/**
	 * write content into a file
	 * @param path the path of file
	 * @param content the content will be write into file.
	 */
	public static void write(String path, String content) {
		try {
			File file = new File(path);
			logger.debug("write file : " + path);
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(content);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
