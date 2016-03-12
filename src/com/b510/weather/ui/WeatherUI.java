/**
 * 
 */
package com.b510.weather.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

/**
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class WeatherUI extends JUI implements ActionListener {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(WeatherUI.class);

	private MainUI mainUI;

	public WeatherUI(String title) {
		super(title);
		logger.debug("title = " + title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void init() {
		if (null == mainUI) {
			mainUI = new MainUI(title);
		}
		mainUI.init();
	}
}
