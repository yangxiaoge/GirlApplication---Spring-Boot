package com.yangxiaoge;

import com.yangxiaoge.domain.Girl;
import com.yangxiaoge.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangxiaoge
 * 2019/3/25 20:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(1);

        Assert.assertEquals(new Integer(18),girl.getAge());
    }
}
