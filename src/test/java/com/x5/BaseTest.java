package com.x5;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml"
//    "classpath:springmvc-servlet.xml",
//    "classpath:SqlMapConfig.xml"
})
public class BaseTest {

}
