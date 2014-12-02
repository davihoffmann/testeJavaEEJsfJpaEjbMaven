package br.com.davi.sistema.dao;

import br.com.davi.sistema.model.Pessoa;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davi
 */
@Stateless
public class PessoaDAO {

    private static final Logger LOG = Logger.getLogger(PessoaDAO.class.getName());
    
    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;
    
    public boolean gravar(Pessoa pessoa) {
        boolean sucesso = false;
        try {
            em.merge(pessoa);
            sucesso = true;
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Erro ao salvar pessoa.", e);
        }
        return sucesso;
    }

    public Pessoa selecionar(int id) {
        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, pessoa);
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Erro ao salvar pessoa.", e);
        }
        return pessoa;
    }

    public boolean remover(Pessoa pessoa) {
        boolean sucesso = false;
        try {
            Pessoa pessoaMerge = em.merge(pessoa);
            em.remove(pessoaMerge);
            sucesso = true;
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Erro ao remover pessoa.", e);
        }
        return sucesso;
    }
    
    public boolean update(Pessoa pessoa) {
        boolean sucesso = false;
        try {
            em.merge(pessoa);
            sucesso = true;
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Erro ao alterar pessoa.", e);
        }
        return sucesso;
    }

    public List<Pessoa> listar() {
        try {
            return em.createNamedQuery("Pessoa.findAll").getResultList();
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Erro ao buscar pessoas.", e);
        }
        return Collections.emptyList();
    }
    
}