package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String email = "nilendrapatel809@example.com";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        System.out.println(m.matches());
    }
}
