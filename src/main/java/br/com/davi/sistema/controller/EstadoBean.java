package br.com.davi.sistema.controller;

import br.com.davi.sistema.model.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named
@SessionScoped
public class EstadoBean implements Serializable {
    
    @EJB
    private br.com.davi.sistema.dao.EstadoDAO estadoDao;
    private Estado estado;
    private DataModel<Estado> estados = null;
    
    public void novo() {
        estado = new Estado();
    }
    
    public String gravar() {
        estadoDao.create(estado);
        return "list?faces-redirect=true";
    }
    
    public String alterar() {
        estadoDao.edit(estado);
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        estadoDao.remove(estado);
        return "list?faces-redirect=true";
    }
    
    public void select() {
        estado = estados.getRowData();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DataModel<Estado> getEstados() {
        List listaEstados = estadoDao.findAll();
        estados = new ListDataModel<>(listaEstados);
        return estados;
    }

    public void setEstados(DataModel<Estado> estados) {
        this.estados = estados;
    }
    
}