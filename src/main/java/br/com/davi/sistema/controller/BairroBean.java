package br.com.davi.sistema.controller;

import br.com.davi.sistema.dao.BairroDAO;
import br.com.davi.sistema.model.Bairro;
import br.com.davi.sistema.model.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named
@SessionScoped
public class BairroBean implements Serializable {
    
    @EJB
    private BairroDAO bairroDao;
    private Bairro bairro;
    private DataModel<Bairro> bairros;
    
    public void novo() {
        bairro = new Bairro();
        bairro.setCidade(new Cidade());
    }
    
    public String gravar() {
        bairroDao.create(bairro);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String alterar() {
        bairroDao.edit(bairro);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        bairro = bairros.getRowData();
        bairroDao.remove(bairro);
        novo();
        return "list?faces-redirect=true";
    }
    
    public void select() {
        bairro = bairros.getRowData();
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public DataModel<Bairro> getBairros() {
        List<Bairro> listaBairros = bairroDao.findAll();
        bairros = new ListDataModel<>(listaBairros);
        return bairros;
    }

    public void setBairros(DataModel<Bairro> bairros) {
        this.bairros = bairros;
    }
    
    public void selectCidadeFromDialog(Cidade cidade) {
        bairro.setCidade(cidade);
    }
    
}