package com.rmpl.business.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vensen
 */
public class ArrayFromatUtil {

	public static String StringformatArray(List<String> arr) {
		String jsonString = JSONObject.toJSONString(arr);
		String replace = jsonString.replace('[', '(').replace(']', ')');
		return replace;
	}

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "a";
		String str3 = "a";
		String str4 = "a";
		String str5 = "a";
		String str6 = "a";
		List<String> strArr = new ArrayList<>();
		strArr.add(str1);
		strArr.add(str2);
		strArr.add(str3);
		strArr.add(str4);
		strArr.add(str5);
		strArr.add(str6);
		String jsonString = JSONObject.toJSONString(strArr);
		System.out.println(JSONObject.toJSONString(jsonString));
		String replace = jsonString.replace('[', '(').replace(']', ')');
		System.out.println(replace);

	}
}
