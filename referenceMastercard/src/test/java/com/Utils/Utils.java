package com.Utils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.context.UserTestContext;
import com.api.context.UserTestContextProvider;

public class Utils {
	/*
	 * @Autowired protected static Environment env;
	 */
	
	public static void DisplayMap(List<Map<String, Object>> results) {
		for (Map<String, Object> map : results) {
			Utils.log("Result : " + map.values().toString(), false);
		}

	}

	public static Object getobjectFromJsonFile(String jsonFilePath)
	{

		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(jsonFilePath));
		} catch (ParseException e) {
			Utils.log(e.getMessage(), false);
			throw e;
		} catch (FileNotFoundException e) {
			Utils.log(e.getMessage(), false);
			throw e;

		} catch (IOException e) {
			Utils.log(e.getMessage(), false);
			throw e;

		}

		return obj;

	}

	public static void log(String log) {
		log(log, true);
	}

	public static void log(String log, boolean isNeedToWrite) {

		if (System.getProperty("isShowTesLogAndFile").equalsIgnoreCase("true")
				|| System.getProperty("isShowTesLogAndFile").equalsIgnoreCase("ON")) {
			UserTestContextProvider.get().getAppLog().info(log);

			if (isNeedToWrite) {
				StringBuilder s = new StringBuilder(System.getProperty("line.separator") + log);
				UserTestContext.loggers.append(s);
			}
		}
	}

	public static StringBuilder newLine() {
		return new StringBuilder(System.getProperty("line.separator"));
	}

	public void logHeader(String message) {

		String fLine = "";
		// String lLine = "";
		for (int i = 0; i < message.length(); i++) {
			fLine += "-";
			// lLine += "-";
		}
		String dash = "";

		for (int i = 1; i <= 20; i++) {
			dash += "-";

		}
		Utils.log(Utils.newLine() + dash + fLine + dash + Utils.newLine() + dash + message + dash + Utils.newLine());

	}

	public void logVerification(String message) {

		String dash = "";

		for (int i = 1; i <= 20; i++) {
			dash += "*";

		}
		Utils.log(Utils.newLine() + dash + message + dash + Utils.newLine());

	}

	public void logFooter(String message, boolean isNeedToLog) {
		// String fLine = "";
		String lLine = "";
		for (int i = 0; i < message.length(); i++) {
			// fLine += "-";
			lLine += "-";
		}
		String dash = "";

		for (int i = 1; i <= 20; i++) {
			dash += "-";

		}
		Utils.log(dash + message + dash + Utils.newLine() + dash + lLine + dash + Utils.newLine(), isNeedToLog);

	}

	public void logStoryHeader(String message) {
		String fLine = "";
		String lLine = "";
		for (int i = 0; i < message.length(); i++) {
			fLine += "=";
			lLine += "=";

		}
		String dash = "";
		String sdash = "";

		for (int i = 1; i <= 60; i++) {
			dash += "=";
			sdash += "*";

		}
		Utils.log(Utils.newLine() + dash + fLine + dash + Utils.newLine() + dash + fLine + dash + Utils.newLine()
				+ sdash + message + sdash + Utils.newLine() + dash + lLine + dash + Utils.newLine() + dash + fLine
				+ dash);

	}

	public void logError(String message) {
		for (int i = 1; i <= 20; i++) {

		}
		String lLine = "";
		for (int i = 0; i < message.length(); i++) {
			lLine += "-";
		}
		String dash = "";

		for (int i = 1; i <= 20; i++) {
			dash += "-";

		}
		Utils.log(Utils.newLine() + dash.substring(2, dash.length()) + "ERROR:" + dash.substring(2, dash.length())
				+ Utils.newLine() + dash + message + dash + Utils.newLine() + dash + lLine + dash + Utils.newLine());

	}

	public void logStoryStarted(String storyName) {

		logStoryHeader("Executing story  :" + storyName);
	}

	public static void displayMap(List<Map<String, Object>> results, boolean islog) {
		Utils.log("No of records it fetched " + results.size(), false);
		for (Map<String, Object> map : results) {
			Utils.log("Query Result : " + map.toString() + newLine(), islog);
		}

	}

	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}

	public static String JavaEncodeBase64(String data) {

		return Base64.getEncoder().encodeToString(data.getBytes());
	}

	public static byte[] JavaDecodeBase64(String data) {

		return Base64.getDecoder().decode(data.getBytes());
	}

	public static String getEncodedStringFromRequestdataWithDataUntilTimeStamp(
			EncryptRequestDataWithDataUntilTimeStamp d) {

		String jsonString = ObjectMapperUtils.writeValueAsString(d);

		return JavaEncodeBase64(jsonString);

	}

	public static String getEncodedStringFromRequestdataWithoutDataUntilTimeStamp(
			EncryptRequestDataWithoutDataUntilTimeStamp d) {
		Utils.log(d.toString());
		String jsonString = ObjectMapperUtils.writeValueAsString(d);
		System.out.println("Encoded BAse 64 string" + JavaEncodeBase64(jsonString));

		return JavaEncodeBase64(jsonString);

	}
	public static String getEncodedStringFromRequestdataWithoutDataUntilTimeStampPUR(
			RequestDataWithoutDataValidPUR d) {

		Utils.log(d.toString());
		String jsonString = ObjectMapperUtils.writeValueAsString(d);
		
		System.out.println("Encoded BAse 64 string" + JavaEncodeBase64(jsonString));

		return JavaEncodeBase64(jsonString);

	}

	public static void main(String sasda[]) {
		String data = "{" + "\"accountNumber\":\"5186009200809412\"," + "\"expiryMonth\":\"08\","
				+ "\"expiryYear\":\"22\"," + "\"source\":\"CARD_ON_FILE\"," + "\"cardholderName\":\"John Doe\","
				+ "\"securityCode\":\"321\"," + "\"billingAddress\":{" + "\"line1\":\"123 Main Street\","
				+ "\"line2\":\"Apt. B12\"," + "\"city\":\"St. Louis\"," + "\"countrySubdivision\":\"MO\","
				+ "\"postalCode\":\"63000\"," + "\"country\":\"USA\"" + "}" + "}";
		EncryptRequestDataWithoutDataUntilTimeStamp request = ObjectMapperUtils.readValue(
				"/Users/e058829/gitrepo/jbehave_unified_tokenize/src/main/resources/config/itf/request/encryptWithoutDataValid.json",
				EncryptRequestDataWithoutDataUntilTimeStamp.class);

		System.out.println(ObjectMapperUtils.writeValueAsString(request));
	}

}

}
