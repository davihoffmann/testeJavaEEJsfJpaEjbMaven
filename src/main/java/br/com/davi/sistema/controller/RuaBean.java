package br.com.davi.sistema.controller;

import br.com.davi.sistema.dao.RuaDAO;
import br.com.davi.sistema.model.Bairro;
import br.com.davi.sistema.model.Rua;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named
@SessionScoped
public class RuaBean implements Serializable {
    
    @EJB
    private RuaDAO ruaDao;
    private Rua rua;
    private DataModel<Rua> ruas;

    public void novo() {
        rua = new Rua();
        rua.setBairro(new Bairro());
    }
    
    public String gravar() {
        ruaDao.create(rua);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String alterar() {
        ruaDao.edit(rua);
        novo();
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        ruaDao.remove(rua);
        novo();
        return "list?faces-redirect=true";
    }
    
    public void select() {
        rua = ruas.getRowData();
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public DataModel<Rua> getRuas() {
        List<Rua> listaRua = ruaDao.findAll();
        ruas = new ListDataModel<>(listaRua);
        return ruas;
    }

    public void setRuas(DataModel<Rua> ruas) {
        this.ruas = ruas;
    }
    
    public void selectBairroFromDialog(Bairro bairro) {
       rua.setBairro(bairro);
    }
    
}