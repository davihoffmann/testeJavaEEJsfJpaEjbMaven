package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Cidade;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CidadeDAO extends UtilDAO<Cidade>{

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public CidadeDAO() {
        super(Cidade.class);
    }
    
    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}