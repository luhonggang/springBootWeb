package com.sanlen.common;

import java.util.Random;

/**
 * @author: LuHongGang
 * @time: 2017/10/24
 * @version: 1.0
 * 随机产生浏览器类型
 */
public class BrowserUtils {
    private static Random random = new Random();
    public static String browserType(){

     return  random.nextInt(6)+"";
    }

    /**
     * 随机生成国内IP地址
     */
    public static String getRandomIp() {

        // ip范围
        int[][] range = { { 607649792, 608174079 },
                { 1038614528, 1039007743 },
                { 1783627776, 1784676351 },
                { 2035023872, 2035154943 },
                { 2078801920, 2079064063 },
                { -1950089216, -1948778497 },
                { -1425539072, -1425014785 },
                { -1236271104, -1235419137 },
                { -770113536, -768606209 },
                { -569376768, -564133889 },
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /**
     * 将十进制转换成ip地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";

        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }

}
