package com.sanlen;

import com.sanlen.common.BrowserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @author: LuHongGang
 * @time: 2017/10/24
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomsRunDetailsTest {

    @Test
    public void testNumber(){
        for (int i = 0; i <50 ; i++) {
            System.out.println("输出的数据是 : ---->>>>"+new Random().nextInt(2));
            System.out.println("随机IP: "+ BrowserUtils.getRandomIp());
        }
    }
}
