package com.linkedin.databaseprogramming.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JPQLExample {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("students");
             EntityManager em = emf.createEntityManager()) {

            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.age > 20", Student.class);
            List<Student> students = query.getResultList();

            System.out.println(students);

        }
    }

}
