package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Categoria;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoriaDAO extends UtilDAO<Categoria> {
    
    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;
    
    public CategoriaDAO() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}