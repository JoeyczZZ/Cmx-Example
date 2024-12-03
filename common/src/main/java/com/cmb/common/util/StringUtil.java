package com.cmb.common.util;

import org.springframework.util.StringUtils;

public class StringUtil {

    public static boolean isNotBlank(String target) {
        return StringUtils.hasText(target);
    }

    public static boolean isBlank(String target) {
        return !isNotBlank(target);
    }
}
