package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Bairro;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BairroDAO extends UtilDAO<Bairro> {
    
    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public BairroDAO() {
        super(Bairro.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}
