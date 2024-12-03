package com.cmb.common.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdUtil {
    public static final SnowFlake snowFlake = new SnowFlake((long)(Math.random() * 32) + 1, (long)(Math.random() * 6) + 1);

    public static String genId() {
        return String.valueOf(snowFlake.nextId());
    }


    public static void main(String[] args) {
//        while (true) {
//            double random = Math.random();
//            System.out.println(random);
//            long num = (long)(random * 32) + 1;
//            if (num > 31) {
//                System.out.println(num);
//            }
//        }
        System.out.println(-1L ^ (-1L << 6));
    }

}
