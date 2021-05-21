package edu.wut.dbexp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenka
 * @use 用户操作逻辑
 * @date 2021/5/218:19
 */
@RestController
@RequestMapping(value = "dbexp/user")
@CrossOrigin
public class UserController {

    /**
     * Test 接口测试
     * @return success
     */
    @GetMapping("/test")
    public String test(@RequestParam("test")String test){
        return  "<h1>success"+test+"</h1>";
    }


}

