package com.tddk.chatbotapp.util;

public class TextJustification {
    //Remove white space and make text lowercase
    public static String justify(String text) {
        return text.trim().replaceAll("\\s+", " ").toLowerCase();
    }
}
