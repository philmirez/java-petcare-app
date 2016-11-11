/*
 * 
 * 
 * 
 * Levels used for identifying the severity of an event. Levels are organized from most specific to least:
 * OFF (most specific, no logging)
 * FATAL (most specific, little data)
 * ERROR
 * WARN
 * INFO
 * DEBUG
 * TRACE (least specific, a lot of data)
 * ALL (least specific, all data)
 * 
 * For more information regarding Log4j2 levels: https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/Level.html
 */

package app.utilities;

import org.apache.logging.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;

/**
 * Logs messages with different severities or formats.
 * 
 * @author Phil Ramirez
 *
 */
public class Log 
{
	private static Logger Logit = LogManager.getLogger(Log.class.getName());
	 
	/**
	 * Logs the Pet Care App Title.
	 *  
	 */
	public static void startApp()
	{
		BasicConfigurator.configure();
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info(" IT 306 Pet Care App ");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 }
	 
	/**
	 * Logs a message to signify the end of the Pet Care App.
	 */
	 public static void endApp()
	 {
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("  App Ended");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
	 }
	 
	 /**
	  * Logs a Fatal Error.
	  * 
	  * @param message A message of where the Fatal Error occurred and the exception.
	  */
	 public static void fatal(String message) 
	 {
		 Logit.fatal(message);
	 }
	 
	 /**
	  * Logs a Error.
	  * 
	  * @param message A message of where the Error occurred and the exception.
	  */
	 public static void error(String message) 
	 {
		 Logit.error(message);
	 }
	 
	 /**
	  * Logs a Warning.
	  * 
	  * @param message A message of where the Warning occurred and the exception.
	  */
	 public static void warn(String message) 
	 {
		 Logit.warn(message);
	 }
	 
	 /**
	  * Logs Information.
	  * 
	  * @param message The information that is to be logged.
	  */
	 public static void info(String message) 
	 {
		 Logit.info(message);
	 }
	 
	 /**
	  * Logs a Debug message.
	  * 
	  * @param message Debug message.
	  */
	 public static void debug(String message) 
	 {
		 Logit.debug(message);
	 } 
	 
	 /**
	  * Logs a Trace.
	  * 
	  * @param message Trace message.
	  */
	 public static void trace(String message)
	 {
		 Logit.trace(message);
	 }
	 
}
