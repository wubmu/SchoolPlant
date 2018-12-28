package o2o.service.impl;

import o2o.dao.UserDao;
import o2o.model.User;
import o2o.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-12-27 18:15
 * description
 */
@Service("/userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.selectAllUser();
    }
}
