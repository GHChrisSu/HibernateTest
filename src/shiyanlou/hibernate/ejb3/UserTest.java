package shiyanlou.hibernate.ejb3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.ejb3.User;

public class UserTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");

        session.save(user);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}