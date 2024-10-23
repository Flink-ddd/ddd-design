package com.rmpl.business.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author vensen
 */
public class CharUtil {

    /**
     * 判断字符串中是否全是中文汉字
     *
     * @param c 字符
     * @return true 含有中文汉字
     * @author zs
     */
    public static boolean isAllChineseOrPoint(String name) {
        if (name == null) {
            return false;
        }
        return CharUtil.isChinese(name.replace("·", ""));
    }

    /**
     * 判断字符串中是否包含数字或者汉字
     *
     * @param c 字符
     * @return true 含有中文汉字
     * @author muxh
     */
    public static boolean isAllChineseOrNumber(String name) {
        if (name == null) {
            return false;
        }
        return CharUtil.isChineseAndNumber(name.replace("·", ""));
    }

    // 完整的判断中文汉字和数字
    public static boolean isChineseAndNumber(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChineseAndNumberCheck(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isChineseAndNumberCheck(char c) {
        String s = String.valueOf(c);
        //判断汉字
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return true;
        }
        //判断数字
        Pattern p2 = Pattern.compile("[0-9]");
        Matcher m2 = p2.matcher(s);
        if (m2.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.trim());
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        } else if (ub == Character.UnicodeBlock.PRIVATE_USE_AREA && c > '\uE000' && c < '\uF8FF') {
            return true;
        }

        return false;
    }

    /**
     * 完整的判断中文汉字和符号
     */
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param content 富文本
     * @Description: 去掉富文本标签
     * @Author: muxh
     * @Date: 2021-01-06 14:12
     * @Return java.lang.String
     */
    public static String dealContent(String content) {
        String regx = "(<.+?>)|(</.+?>)|[/&@#*!]|[getploi]|(<\\>)";
        Matcher matcher = Pattern.compile(regx).matcher(content);
        while (matcher.find()) {
            // 替换图片
            content = matcher.replaceAll("").replace("", "");
        }
        return content;
    }

    /**
     * 提取汉字
     */
    public static String getChinese(String str) {
        String regx = "([\u4e00-\u9fa5]+)";
        String Chinese = "";
        Matcher matcher = Pattern.compile(regx).matcher(str);
        while (matcher.find()) {
            Chinese += matcher.group(0);
        }
        return Chinese;
    }

    /**
     * 过滤特殊符号
     *
     * @param str
     * @return str(只留数字汉字字母和少数标点符号)
     * @version 1.0
     */
    public static String filter(String str) {
        if (str.trim().isEmpty()) {
            return str;
        }
        String pattern = "[\u4E00-\u9FA5]|[\\w]|[,.，。@#￥*！：!~$]";// 汉字
        Pattern emoji = Pattern.compile(pattern);
        Matcher emojiMatcher = emoji.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (emojiMatcher.find()) {
            sb.append(emojiMatcher.group());
        }
        return sb.toString();
    }

    /**
     * 字符串兼容中英文分号、逗号
     */
    public static List<String> compatible(String value) {
        List<String> stringList = new ArrayList<>();
        String regex = ",|，|\\s+|；|;";
        String strings[] = value.split(regex);
        stringList = Stream.of(strings).map(String::toString).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for (String s : stringList) {
            if (StringUtils.isNotBlank(s)) {
                list.add(s);
            }
        }
        return list;
    }

}