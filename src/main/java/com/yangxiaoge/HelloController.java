package com.yangxiaoge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangxiaoge
 * 2019/3/25 11:07
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    GirlProperties girlProperties;

    @RequestMapping(value = {"/sayHello", "/sayHi"}, method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize() + girlProperties.getAge();
    }

    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String pathVariable(@PathVariable("id") Integer pathId) {
        return "id = " + pathId;
    }

    //@RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String requestParam(@RequestParam(value = "id", required = false, defaultValue = "8888") Integer reqId) {
        return "id = " + reqId;
    }
}