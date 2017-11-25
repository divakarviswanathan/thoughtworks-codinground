package com.thoughtworks.business.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringParserUtil {

	public static String[] parseString(String charSequence) {
		StringTokenizer tokenizer = new StringTokenizer(charSequence, ",");
		String[] str = new String[tokenizer.countTokens()];
		int i = 0;
		while (tokenizer.hasMoreTokens()) {
			str[i++] = tokenizer.nextToken();
		}
		return str;
	}

	public static List<Integer> parseStringToNumberList(String numberSequence) {
		String[] numberSequenceStr = parseString(numberSequence);
		List<Integer> numberList = new ArrayList<>();
		for (String str : numberSequenceStr) {
			numberList.add(Integer.parseInt(str));
		}
		return numberList;
	}

}
