package br.com.davi.sistema.controller;

import br.com.davi.sistema.dao.EnderecoDAO;
import br.com.davi.sistema.model.Endereco;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class EnderecoBean implements Serializable {
    
    @EJB
    private EnderecoDAO enderecoDao;
    private Endereco endereco;
    
    public void novo() {
        endereco = new Endereco();
    }
    
    public String gravar() {
        enderecoDao.create(endereco);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String alterar() {
        enderecoDao.edit(endereco);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        enderecoDao.remove(endereco);
        novo();
        return "list?faces-redirect=true";
    }
    
}