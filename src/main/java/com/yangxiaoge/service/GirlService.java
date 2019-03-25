package com.yangxiaoge.service;

import com.yangxiaoge.domain.Girl;
import com.yangxiaoge.exception.GirlException;
import com.yangxiaoge.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by yangxiaoge
 * 2019/3/25 17:42
 */
@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    //事务管理， 必须都成功才能插入数据库
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(100,"你还在上小学吧");
        } else if (age > 10 && age < 16) {
            throw new GirlException(101,"你还在上初中吧");
        }
    }
}
