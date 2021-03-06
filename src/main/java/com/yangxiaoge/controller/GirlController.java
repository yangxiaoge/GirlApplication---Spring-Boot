package com.yangxiaoge.controller;

import com.yangxiaoge.domain.Girl;
import com.yangxiaoge.domain.Result;
import com.yangxiaoge.repository.GirlRepository;
import com.yangxiaoge.service.GirlService;
import com.yangxiaoge.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by yangxiaoge
 * 2019/3/25 16:28
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public Result<List<Girl>> girlList() {
        return ResultUtil.success(girlRepository.findAll());
    }

    /**
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Result<Girl> findGirl(@PathVariable(value = "id") Integer id) {
//        return girlRepository.findOne(id);
        return ResultUtil.success(girlRepository.findById(id).orElse(null));
    }

    /**
     * 通过年龄查询女生列表
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public Result<List<Girl>> girlListByAge(@PathVariable("age") Integer age) {
        return ResultUtil.success(girlRepository.findByAge(age));
    }

    /**
     * 更新一个女生
     *
     * @param id
     * @param newGirl
     * @return
     */
    @PutMapping(value = "/girls/{id}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<Girl> updateGirl(@PathVariable(value = "id") Integer id,
                                   @RequestBody Girl newGirl) {
        Optional<Girl> optional = girlRepository.findById(id);
        if (optional.isPresent()) {
            Girl girl = optional.get();
            girl.setId(id);
            girl.setCupSize(newGirl.getCupSize());
            girl.setAge(newGirl.getAge());
            girl.setMoney(newGirl.getMoney());
            return ResultUtil.success(girlRepository.save(girl));
        }

        return ResultUtil.error(1, "妹子不存在");
    }

    /**
     * 删除一个女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable(value = "id") Integer id) {
        girlRepository.deleteById(id);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}