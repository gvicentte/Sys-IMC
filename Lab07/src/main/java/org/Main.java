package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.model.Colaborador;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab07");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Colaborador colaborador = new Colaborador();
        colaborador.setNome("Gabriel Vicentte");
        colaborador.setEmail("gvicentte10@gmail.com");
        colaborador.setMatricula("80117283");
        em.persist(colaborador);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}