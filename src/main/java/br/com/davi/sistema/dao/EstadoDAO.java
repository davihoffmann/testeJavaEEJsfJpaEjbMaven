package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Estado;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstadoDAO extends UtilDAO<Estado> {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public EstadoDAO() {
        super(Estado.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}