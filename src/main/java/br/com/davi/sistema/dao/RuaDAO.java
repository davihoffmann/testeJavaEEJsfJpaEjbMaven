package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Rua;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RuaDAO extends UtilDAO<Rua>{

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public RuaDAO() {
        super(Rua.class);
    }
    
    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}