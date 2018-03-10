package shiyanlou.hibernate.manytomany.test;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.manytomany.entity.Course;
import shiyanlou.hibernate.manytomany.entity.Student;

public class UserTest {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
          @SuppressWarnings("deprecation")
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        // �½����ſγ�
        Set<Course> courses = new HashSet<Course>();
        Course c1 = new Course();
        c1.setCou_name("Chinese");
        Course c2 = new Course();
        c2.setCou_name("English");
        Course c3 = new Course();
        c3.setCou_name("Math");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        // �½�����ѧ��
        Set<Student> students = new HashSet<Student>();
        Student s1 = new Student();
        s1.setStu_name("Michael");
        Student s2 = new Student();
        s2.setStu_name("KangKang");
        Student s3 = new Student();
        s3.setStu_name("Jane");
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // ������ѧ����������ÿһ�ſγ���
        c1.setStudents(students);
        c2.setStudents(students);
        c3.setStudents(students);

        // ������ض���
        session.save(c1);
        session.save(c2);
        session.save(c3);

        session.getTransaction().commit();
        session.close();
        sf.close();
    }

}