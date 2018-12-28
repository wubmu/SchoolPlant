package o2o.controller;

import o2o.model.User;
import o2o.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-12-27 18:13
 * description
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService service;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<User> showAll(){
        System.out.println(service.findAll());
        return service.findAll();
    }

}
