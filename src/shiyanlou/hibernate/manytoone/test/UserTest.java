package shiyanlou.hibernate.manytoone.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.manytoone.entity.Group;
import shiyanlou.hibernate.manytoone.entity.User;

public class UserTest {

    public static void main(String[] args) {

        // 加载 Hibernate 配置文件
        Configuration cfg = new Configuration().configure();

        // 新建 SessionFactory
         @SuppressWarnings("deprecation")
        SessionFactory sf = cfg.buildSessionFactory();

        // 开启 Session
        Session session = sf.openSession();

        // 开启事务
        session.beginTransaction();


        // 新建一个 LOL 群组
        Group group = new Group();
        group.setGroupname("LOL_Group");


        // 新建多个用户
        User user1 = new User();
        user1.setUsername("Levis");
        user1.setPassword("111");

        User user2 = new User();
        user2.setUsername("Lee");
        user2.setPassword("222");

        // 设置多个用户都对应该群组（多对一）
        user1.setGroup(group);
        user2.setGroup(group);

        // 保存相关对象
        session.save(user1);
        session.save(user2);
        session.save(group);

        // 提交事务并关闭 session
        session.getTransaction().commit();
        session.close();
        sf.close();    
    }    
}