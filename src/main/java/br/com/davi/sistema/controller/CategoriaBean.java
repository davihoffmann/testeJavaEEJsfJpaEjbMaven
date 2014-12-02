package br.com.davi.sistema.controller;

import br.com.davi.sistema.model.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named
@SessionScoped
public class CategoriaBean implements Serializable {
    
    @EJB
    private br.com.davi.sistema.dao.CategoriaDAO categoriaDao;
    private Categoria categoria;
    private DataModel<Categoria> categorias = null;
    
    public void novo() {
        categoria = new Categoria();
    }
    
    public String gravar() {
        categoriaDao.create(categoria);
        return "list?faces-redirect=true";
    }
    
    public String alterar() {
        categoriaDao.edit(categoria);
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        categoriaDao.remove(categoria);
        return "list?faces-redirect=true";
    }
    
    public void select() {
        categoria = categorias.getRowData();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public DataModel<Categoria> getCategorias() {
        List listaCategoria = categoriaDao.findAll();
        categorias = new ListDataModel<>(listaCategoria);
        return categorias;
    }

    public void setCategorias(DataModel<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}