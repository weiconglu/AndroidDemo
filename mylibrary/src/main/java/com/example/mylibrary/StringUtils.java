package com.example.mylibrary;

public class StringUtils {

    /**
     * 如果这个字符串是null或者空字符串返回true
     *
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        return (null == string || "".equals(string.trim()));
    }

    /**
     * 如果这个字符串不是null且不是空字符串返回true
     *
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

}
