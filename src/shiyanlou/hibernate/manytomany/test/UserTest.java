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

        // 新建三门课程
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

        // 新建三个学生
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

        // 将三个学生都关联到每一门课程中
        c1.setStudents(students);
        c2.setStudents(students);
        c3.setStudents(students);

        // 保存相关对象
        session.save(c1);
        session.save(c2);
        session.save(c3);

        session.getTransaction().commit();
        session.close();
        sf.close();
    }

}