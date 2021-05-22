package edu.wut.dbexp.Controller;

import edu.wut.dbexp.Error.EmBusinessError;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Test 接口测试
     *
     * @return success
     */
    @GetMapping("/test")
    public String test(@RequestParam("test") String test) {
        return "<h1>success" + test + "</h1>";
    }

    @PostMapping("/login")
    public CommonReturnType login(@RequestParam("userName") String userName,
                                  @RequestParam("userPwd") String Pwd) {
        if (userService.login(userName,Pwd)){
            return CommonReturnType.create(userName,"success");
        }else {
            return CommonReturnType.create(EmBusinessError.LOGIN_FAILED,"pwd is wrong or user is not exit");
        }
    }

}

