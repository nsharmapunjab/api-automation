package com.api.test.framework.logger;

import org.testng.Reporter;

public class ReportNGLogger extends Reporter implements TLogger {

	static {
		// to enable links or usage of tags in the HTML reporter
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	public static void log(String message) {
		System.out.println(message);
		Reporter.log(message + "<br>");
	}

	public static void log(String message, boolean logToStandardOut) {
		System.out.println(message);
		Reporter.log(message + "<br>");
	}

	@Override
	public void logMessage(String mssg) {

		log(mssg);
	}

}
