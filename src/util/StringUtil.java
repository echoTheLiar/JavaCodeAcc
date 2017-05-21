package util;

import java.util.Random;

/**
 * Util for String
 * 
 * @author liu yuning
 *
 */
public class StringUtil {

    private static final int DEFAULT_STRING_LENGTH = 10;

    private static final String LETTERS = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Random random = new Random();

    /**
     * Don't let anyone instantiate this class.
     */
    private StringUtil() {

    }

    /**
     * 
     * @param str
     * @return {@code true} if the input {@code String} is null or ""
     */
    public static boolean empty(final String str) {
	return str == null || str.trim().isEmpty();
    }

    /**
     * generate random string
     * 
     * @return a random string
     */
    public static String generateRandomString() {
	return generateRandomString(DEFAULT_STRING_LENGTH);
    }

    /**
     * generate random string using all letters and the given length
     * 
     * @param stringLength
     * @return a random string
     */
    public static String generateRandomString(int stringLength) {
	if (stringLength <= 0) {
	    stringLength = DEFAULT_STRING_LENGTH;
	}

	StringBuilder stringBuilder = new StringBuilder();

	for (int i = 0; i < stringLength; i++) {
	    stringBuilder
		    .append(LETTERS.charAt(random.nextInt(LETTERS.length())));
	}

	return stringBuilder.toString();
    }

    /**
     * repeat a {@code String} called repeatStr for repeatNum times
     * 
     * @param repeatStr
     * @param repeatNum
     * @return {@code String} repeatedString
     */
    public static String repeatableString(String repeatStr, int repeatNum) {
	StringBuilder stringBuilder = new StringBuilder();

	while (repeatNum-- > 0) {
	    stringBuilder.append(repeatStr);
	}

	return stringBuilder.toString();
    }

}
