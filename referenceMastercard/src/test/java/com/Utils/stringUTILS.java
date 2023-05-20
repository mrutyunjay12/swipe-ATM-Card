package com.Utils;

public class stringUTILS {
	private static final Logger log = Logger.getLogger(MDCCStringUtils.class);
	public static String returnBlankIfNull(String input) {
		return input == null ? "" : input;
	}
	
	public static String generateRandomStringOfSize(int size) {
		return RandomStringUtils.randomAlphanumeric(size);
	}

	public static String generateRandomEmail(int length) {
		if (length == 0) {
			return "";
		} else if (length > 15) {
			return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz").substring(0, length - 15)
					+ "@mastercard.com";
		} else {
			return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + "@mastercard.com";
		}
	}
	public static String generateRandomColorCode(int length) {
			return RandomStringUtils.random(length, "1234567890ABCDEF");
	}
	public static String generateRandomWebsite(int length) {
		if (length == 0) {
			return "";
		} else if (length > 27) {
			return "https://www."
					+ RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz").substring(0, length - 27)
					+ ".mastercard.com";
		} else {
			return "https://www." + RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + ".mastercard.com";
		}

	}

	public static String generateRandomPhoneNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static String generateRandomUrl(int length) {
		if (length == 0) {
			return "";
		} else if (length > 27) {
			return "https://" + RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz").substring(0, length - 27)
					+ ".mastercard.com/abc";
		} else {
			return "https://" + RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + ".mastercard.com/abc";
		}

	}
	
	public static String[] stringSplit(String inputString,String delimiter)
	{
		return inputString.split(delimiter);	
	}
	

	public static List<String> splitString(String inputString,
			String delimiter) {
		List<String> strList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(inputString.trim(),delimiter.trim());
		while (st.hasMoreElements()) {
			strList.add(st.nextToken().trim());
		}
		return strList;
	}

	/*
	 * @Method : splitSting
	 * @Param1 : Input String
	 * @Param2 : Delimiter to split String
	 * @Description : return true if i/p ArrayList contain duplicates
	 * @Authoer : Suresh
	 */
	public static boolean hasDuplicates(List<String> inputArryList)
			throws Exception {
		boolean result = false;
		if (inputArryList.size() > 0) {
			Set<String> set = new HashSet<String>();
			for (String attribVal : inputArryList) {
				set.add(attribVal.trim());
			}

			if (inputArryList.size() > set.size()) {
				result = true;
			}

		}
		return result;
	}


	/*
	 * @Method : SplitArryLit
	 * @Param1 : String delimiter separated
	 * @Param2 : String delimiter separated
	 * @Description : return true if Param1 elements in Param2
	 * @Authoer : Suresh
	 */
	public static boolean compareLists(String strfromlist, String strtoList)
			throws Exception {
		List<String> fromlist = splitString(strfromlist, ";");
		List<String> tolist = splitString(strtoList, ";");
		return compareLists(fromlist, tolist);
	}

	/*
	 * @Method : SplitArryLit
	 * @Param1 : List of Elements
	 * @Param2 : List of Elemetns
	 * @Description : return true if Param1 elements in Param2
	 * @Authoer : Suresh
	 */
	public static boolean compareLists(List<String> fromList,
			List<String> toList){
		
		for (int i = 0; i < fromList.size(); i++) {
			if (!toList.contains(fromList.get(i).toString())) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * @Method:isEmpty
	 * 
	 * @Author:Bhavya
	 * 
	 * @Params 1: Attribute value(String) Returns Boolean
	 */
	public static boolean isEmpty(String attributeValue) throws Exception {
		boolean isNull = false;
		if (attributeValue.trim().isEmpty()) {
			isNull = true;
		}
		return isNull;
	}

	/*
	 * @Method:hasTextContainsString
	 * @Author:Suresh
	 * @Params 1: element text
	 * @Params 2: element String to verify Returns Boolean
	 */
	public static boolean hasTextContainsString(String actual, String expected)
			throws Exception {

		boolean result = false;
		if (actual.contains(expected)) {
			result = true;
		}
		return result;

	}

	/*
	 * author: Suresh Desc : to get Part Number between two words in banner
	 * Message / History Message
	 */

	public static String getTextBetweenWords(String message, String before,
			String after) throws Exception {
		String text = "";
		// Pattern pattern = Pattern.compile("(?<=SavedAs).*.(?=successfully)");
		Pattern pattern = Pattern.compile("(?<=" + before + ").*.(?=" + after
				+ ")");
		Matcher matcher = pattern.matcher(message);

		boolean found = false;
		while (matcher.find()) {
			log.info("Text between given phrases is:: " + matcher.group());
			text = matcher.group().trim();

			found = true;
		}
		if (!found) {
			log.info("No text found");
		}

		return text;
	}
	
	public static Long getWhiteListingNmberFromAccRange(String accountRangeName, int Panlegth)
	{
		  String whiteListingNumber ="";
		  if(accountRangeName.contains(")"))
 		  {
		    whiteListingNumber = org.apache.commons.lang3.StringUtils.rightPad(MDCCStringUtils.splitString(MDCCStringUtils.splitString(accountRangeName, "-").get(0), ")").get(1), Panlegth,'0');
	 	   log.info("when bracket:"+whiteListingNumber);
 		  }else{
 			    whiteListingNumber = org.apache.commons.lang3.StringUtils.rightPad(MDCCStringUtils.splitString(accountRangeName, "-").get(0), Panlegth,'0');
 		 	log.info(whiteListingNumber);  
 		  }
		  whiteListingNumber =whiteListingNumber.replaceAll("\\s+", "");
		  log.info("afgter remove:"+whiteListingNumber); 
		  
		  return Long.parseLong(whiteListingNumber);
	}
	
	public static String getRandomStringByType(int maxlength, String strType) {
		Random rand = new Random();
		String possibleLetters = "";
		StringBuilder sb = null;
		if("AlphaNumeric".equals(strType))
		{
			possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			 sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{
				sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}if("AlphaNumericandSpecChar".equals(strType))
		{
			possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#!$%^&*";
			 sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{
				sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}
		else if ("Numeric".equalsIgnoreCase(strType)) 
		{
			possibleLetters = "0123456789";
			sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
			
		}
		else if ("SpecialChars".equalsIgnoreCase(strType)) 
		{
			possibleLetters = "!@#$%^&* ";
			sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}else if ("Alphabet".equalsIgnoreCase(strType))
		{
			possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));}
		}else if("AlphabetUpper".equalsIgnoreCase(strType))
		{
			possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{ 	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}if ("AlphabetLower".equalsIgnoreCase(strType))
		{
			possibleLetters = "abcdefghijklmnopqrstuvwxyz";
			sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}if ("AlphaNumericandSpecCharwithSpace".equalsIgnoreCase(strType))
		{
			possibleLetters = " ABCDEFGHIJK LMNOPQRSTUVWXYZ abcdefghijkl mnopqrstuvwxyz 01234 56789 @#!$ %^&* ";
			 sb = new StringBuilder(maxlength);
			for (int i = 0; i < maxlength; i++)
			{
				sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
						.length())));
			}
		}
			return sb.toString();
	}
	
	public static String getRandomString(int maxlength) {
		Random rand = new Random();
		String possibleLetters = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(maxlength);
		for (int i = 0; i < maxlength; i++)
		{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
					.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomStringWithSpecialChars(int maxlength) {
		Random rand = new Random();
		String possibleLetters = "abdefuvwyz!@#$%^&*01249";
		StringBuilder sb = new StringBuilder(maxlength);
		for (int i = 0; i < maxlength; i++)
		{	sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters
					.length()))); }
		return sb.toString();
	}
	
	public static int getRandomNumForMax(int maxValue)
	{
		Random rand = new Random(); 
		return rand.nextInt(maxValue);
	}
	
	public static void main(String args[])
	{
		
		
		//String str1 = "Mastercard Credit";
		//String str2 = "Mastercard Credit";
		
		
		String str1 = "Mastercard Credit";
		String str2 = "Mastercard Credit";
		
		if(str1.equalsIgnoreCase(str2))
		{
			System.out.println("Both are equal");
		}else
		{
			System.out.println("Both are not equal");
		}
		if(str1.contentEquals(str2))
		{
			System.out.println("Both are equal");
		}else
		{
			System.out.println("Both are not equal");
		}
		
		if(str1.contains(str2))
		{
			System.out.println("Both are equal");
		}else
		{
			System.out.println("Both are not equal");
		}
		
	  String strtoSplit = "Viewing 1 - 10 of 54";
	  String[] strarry =  stringSplit(strtoSplit,"of");
	  System.out.println("final value"+strarry[1]);
	  int ctr = Integer.valueOf(strarry[1].trim());
	  System.out.println("final value"+ctr);
	  
	}

	/**
	 * @param prefixString is the string with which user wants the random string to start with
	 * @param numOfSpecialChars is the desired number of special characters in the string
	 * @author e035290
	 * @return required String with special characters & random numbers
	 */
	public static String getAlphaNumericSpecialCharRandomName (String prefixString, int numOfSpecialChars) {
		StringBuilder sb = new StringBuilder("Test_");
		sb.append(MDCCStringUtils.getRandomStringByType(3,"SpecialChars"));
		sb.append(Long.toString(System.currentTimeMillis() / MDCCConstant.THOUSAND));
		return sb.toString();
	}

	



}
