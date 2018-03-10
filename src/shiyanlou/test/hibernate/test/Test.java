package shiyanlou.test.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.test.hibernate.entity.User;

public class Test {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // 利用 StringBuilder 来连接查询语句
        StringBuilder hq = new StringBuilder();

        // 从 User 里面查找（注意 from 后有空格）
        // 相当于 "select * from user_info;"
        hq.append("from ").append( User.class.getName() );

        // 利用 session 建立 query
        Query query = session.createQuery( hq.toString() );

        // 序列化 query 的结果为一个 list 集合
        List<User> users = query.list();

        // 打印每一个 User 信息（这里只打印了名字，你也可以打印其他信息）
        for (User user : users) {
            System.out.println( user.getUsername() );

        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}