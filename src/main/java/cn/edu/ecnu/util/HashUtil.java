package cn.edu.ecnu.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

    public static String getSha256(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
