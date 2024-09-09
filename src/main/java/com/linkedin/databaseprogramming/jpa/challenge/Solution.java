package com.linkedin.databaseprogramming.jpa.challenge;

import com.linkedin.databaseprogramming.jpa.Course;
import com.linkedin.databaseprogramming.jpa.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("students");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Course course = new Course();
            course.setCourseName("Java fuer Fortgeschrittene");
            course.setDuration(40);
            em.persist(course);

            Course course2 = new Course();
            course2.setCourseName("Datenbank Grundlagen");
            course2.setDuration(20);
            em.persist(course2);

            Student student1 = new Student();
            student1.setName("Max Mustermann");
            student1.setAge(21);
            student1.setCourse(course);
            em.persist(student1);

            Student student2 = new Student();
            student2.setName("Erika Musterfrau");
            student2.setAge(23);
            student2.setCourse(course2);
            em.persist(student2);

            em.getTransaction().commit();

            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.course.courseName = 'Datenbank Grundlagen'"
                    , Student.class);
            List<Student> students = query.getResultList();

            System.out.println(students);

        }
    }

}
