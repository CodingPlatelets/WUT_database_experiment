package edu.wut.dbexp.Controller;

import com.alibaba.fastjson.JSON;
import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Error.EmBusinessError;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.UserService;
import edu.wut.dbexp.Utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    @PostMapping("/Adb/login")
    public CommonReturnType login(@RequestParam("userName") String userName,
                                  @RequestParam("userPwd") String Pwd) {
        if (userService.login(userName, Pwd)) {
            return CommonReturnType.create(userName, "success");
        } else {
            return CommonReturnType.create(EmBusinessError.LOGIN_FAILED, "pwd is wrong or user is not exit");
        }
    }

    @PostMapping("/register")
    public CommonReturnType addUser(@RequestParam("username") String username,
                                    @RequestParam("vipStatus") int vipStatus,
                                    @RequestParam("balance") double balance,
                                    @RequestParam("phoneNumber") String phoneNumber,
                                    @RequestParam("gender") int gender
    ) throws Exception {
        User user = new User();
        user.setId(IdUtils.getPrimaryKey());
        user.setUserName(username);
        user.setVipStatus(vipStatus);
        user.setBalance(balance);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        if (userService.addUser(user)) {
            return CommonReturnType.create(JSON.toJSON(user),"success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "check your information!");
    }

    @PostMapping("/update/userName")
    public CommonReturnType upadateUsername(@RequestParam("id") String id,
                                            @RequestParam("userName") String userName) throws Exception {
        User user = userService.searchUser(id);
        user.setUserName(userName);
        if (userService.updateUser(user)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "failed");
    }

    @PostMapping("/update/vipStatus")
    public CommonReturnType upadateVipstatus(@RequestParam("id") String id,
                                             @RequestParam("vipStatus") int vipStatus) throws Exception {
        User user = userService.searchUser(id);
        user.setVipStatus(vipStatus);
        if (userService.updateUser(user)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "failed");
    }

    @PostMapping("/update/balance")
    public CommonReturnType upadateBalance(@RequestParam("id") String id,
                                           @RequestParam("balance") double balance) throws Exception {
        User user = userService.searchUser(id);
        user.setBalance(balance);
        if (userService.updateUser(user)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "failed");
    }

    @PostMapping("/update/phoneNumber")
    public CommonReturnType upadatePhoneNumber(@RequestParam("id") String id,
                                               @RequestParam("phoneNumber") String phoneNumber) throws Exception {
        User user = userService.searchUser(id);
        user.setPhoneNumber(phoneNumber);
        if (userService.updateUser(user)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "failed");
    }

    @PostMapping("/update/gender")
    public CommonReturnType upadateGender(@RequestParam("id") String id,
                                          @RequestParam("gender") int gender) throws Exception {
        User user = userService.searchUser(id);
        user.setGender(gender);
        if (userService.updateUser(user)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "failed");
    }

    @PostMapping("/delete")
    public CommonReturnType deleteUser(@RequestParam("id") String id) {
        if (userService.deleteUser(id)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "delete failed");
    }

}

