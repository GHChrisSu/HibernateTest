package shiyanlou.hibernate.manytoone.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.manytoone.entity.Group;
import shiyanlou.hibernate.manytoone.entity.User;

public class UserTest {

    public static void main(String[] args) {

        // ���� Hibernate �����ļ�
        Configuration cfg = new Configuration().configure();

        // �½� SessionFactory
         @SuppressWarnings("deprecation")
        SessionFactory sf = cfg.buildSessionFactory();

        // ���� Session
        Session session = sf.openSession();

        // ��������
        session.beginTransaction();


        // �½�һ�� LOL Ⱥ��
        Group group = new Group();
        group.setGroupname("LOL_Group");


        // �½�����û�
        User user1 = new User();
        user1.setUsername("Levis");
        user1.setPassword("111");

        User user2 = new User();
        user2.setUsername("Lee");
        user2.setPassword("222");

        // ���ö���û�����Ӧ��Ⱥ�飨���һ��
        user1.setGroup(group);
        user2.setGroup(group);

        // ������ض���
        session.save(user1);
        session.save(user2);
        session.save(group);

        // �ύ���񲢹ر� session
        session.getTransaction().commit();
        session.close();
        sf.close();    
    }    
}