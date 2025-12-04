package org.projetosyslocacar.dao;

import org.hibernate.Session;
import org.projetosyslocacar.model.Modelo;
import org.projetosyslocacar.utils.HibernateUtil;

import java.util.List;

public class ModeloDAO extends GenericDAO<Modelo, Long>{

    public ModeloDAO(Class<Modelo> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Modelo> buscarTodos() {
        Session session = null;
        try {
            // Certifique-se de que seu HibernateUtil está sendo usado aqui
            session = HibernateUtil.getSessionFactory().openSession();

            // HQL com FETCH JOIN para carregar Marca e Categoria na mesma query
            List<Modelo> modelos = session.createQuery(
                    "SELECT m FROM Modelo m JOIN FETCH m.marca JOIN FETCH m.categoria",
                    Modelo.class
            ).getResultList();

            return modelos;

        } catch (Exception e) {
            e.printStackTrace();
            return null; // ou throw new RuntimeException("Erro ao buscar modelos", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
