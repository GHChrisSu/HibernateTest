package shiyanlou.hibernate.ejb3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// @Table(name="")
// 数据库中默认会对应生成同名的 Table
// 如果要修改 Table 名，使用 @Table(name="")
// "" 内为自定义的 Table 名
public class User {

    private int id;
    private String username;
    private String password;

    @Id
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