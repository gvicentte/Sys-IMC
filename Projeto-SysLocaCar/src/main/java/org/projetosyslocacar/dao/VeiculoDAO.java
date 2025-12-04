package org.projetosyslocacar.dao;

import org.projetosyslocacar.model.Veiculo;

public class VeiculoDAO extends GenericDAO<Veiculo,Long>{
    public VeiculoDAO(Class<Veiculo> entityClass) {
        super(entityClass);
    }
}
