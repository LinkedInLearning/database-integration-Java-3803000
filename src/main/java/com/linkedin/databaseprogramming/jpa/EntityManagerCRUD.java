package com.linkedin.databaseprogramming.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerCRUD {

    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("students");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Student student = new Student();
            student.setName("Erika Musterfrau");
            student.setAge(23);
            em.persist(student);

            System.out.println(student);

//            Student foundStudent = em.find(Student.class, 1);
//            foundStudent.setName("Erika Musterfrau");
//            em.merge(foundStudent);

//            em.remove(foundStudent);

            em.getTransaction().commit();


        }

    }

}
