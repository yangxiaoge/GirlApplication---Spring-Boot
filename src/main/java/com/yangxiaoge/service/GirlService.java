package com.yangxiaoge.service;

import com.yangxiaoge.domain.Girl;
import com.yangxiaoge.enums.ResultEnum;
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
        girlA.setMoney(666.0);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBB");
        //girlB.setMoney(888.0);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    //查询一个女生信息
    public Girl findOne(Integer id){
        return girlRepository.findById(id).orElse(null);
    }
}
