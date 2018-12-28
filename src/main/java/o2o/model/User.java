package o2o.model;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-12-27 17:51
 * description
 */
@Component
public class User {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
