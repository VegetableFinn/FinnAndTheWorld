package com.assistant.utils;

/**
 * @author hefan.hf
 * @version $Id: FileUtil, v 0.1 16/4/19 14:56 hefan.hf Exp $
 */
public class FileUtil {

    private static boolean isDev = false;

    /**
     * 获得ONE的保存目录
     */
    public static String getOnePicFolder() {

        if (!isDev) {
            return "/root/files/ones/";
        } else {
            return "/Users/hefan/Documents/git/files/";
        }

    }
}