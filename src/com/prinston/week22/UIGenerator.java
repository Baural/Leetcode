package com.prinston.week22;

import java.util.UUID;

/**
 * @author Baurzhan Alzhanov
 * @date on 14.07.2021
 */


public class UIGenerator {
    public static void main(String[] args) {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        System.out.println(uid);
    }
}
