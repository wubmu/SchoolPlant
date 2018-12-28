package o2o.dao;

import o2o.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-12-27 18:03
 * description
 */
public interface UserDao {
    List<User> selectAllUser();
    void save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
}
