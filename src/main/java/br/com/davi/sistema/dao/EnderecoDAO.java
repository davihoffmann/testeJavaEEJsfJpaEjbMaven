package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Endereco;
import br.com.davi.sistema.util.UtilDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoDAO extends UtilDAO<Endereco>{
    
    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public EnderecoDAO() {
        super(Endereco.class);
    }
    
    @Override
    protected EntityManager getEm() {
        return em;
    }
    
}