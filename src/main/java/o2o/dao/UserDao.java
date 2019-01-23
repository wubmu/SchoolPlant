package o2o.dao;

import o2o.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-08 14:17
 * description
 */
public interface UserDao {

    int delete( int id);
}
