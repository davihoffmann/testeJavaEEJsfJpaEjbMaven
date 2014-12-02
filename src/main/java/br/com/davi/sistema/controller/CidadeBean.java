package br.com.davi.sistema.controller;

import br.com.davi.sistema.dao.CidadeDAO;
import br.com.davi.sistema.model.Cidade;
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
public class CidadeBean implements Serializable {

    @EJB
    private CidadeDAO cidadeDao;
    private Cidade cidade;
    private DataModel<Cidade> cidades;

    public void novo() {
        cidade = new Cidade();
        cidade.setEstado(new Estado());
    }

    public String gravar() {
        cidadeDao.create(cidade);
        novo();
        return "list?faces-redirect=true";
    }

    public String alterar() {
        cidadeDao.edit(cidade);
        novo();
        return "list?faces-redirect=true";
    }

    public String remover() {
        cidade = cidades.getRowData();
        cidadeDao.remove(cidade);
        novo();
        return "list?faces-redirect=true";
    }

    public void select() {
        cidade = cidades.getRowData();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DataModel<Cidade> getCidades() {
         List<Cidade> cidadeList = cidadeDao.findAll();
        cidades = new ListDataModel<>(cidadeList);
        return cidades;
    }

    public void setCidades(DataModel<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public void selectEstadoFromDialog(Estado estado) {
        cidade.setEstado(estado);
    }

}
