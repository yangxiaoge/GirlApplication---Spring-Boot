package com.yangxiaoge.repository;

import com.yangxiaoge.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yangxiaoge
 * 2019/3/25 16:30
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询Girl
    List<Girl> findByAge(Integer age);
}
