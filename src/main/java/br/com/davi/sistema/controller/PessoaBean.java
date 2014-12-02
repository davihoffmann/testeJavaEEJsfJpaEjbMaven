package br.com.davi.sistema.controller;

import br.com.davi.sistema.dao.PessoaDAO;
import br.com.davi.sistema.model.Bairro;
import br.com.davi.sistema.model.Cidade;
import br.com.davi.sistema.model.Endereco;
import br.com.davi.sistema.model.Estado;
import br.com.davi.sistema.model.Pessoa;
import br.com.davi.sistema.model.Rua;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named(value = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {
    
    @EJB
    private br.com.davi.sistema.dao.PessoaDAO pessoaDAO;
    private Pessoa pessoa = new Pessoa();
    private DataModel<Pessoa> pessoas = null;
    
    private PessoaDAO getDao() {
        return pessoaDAO;
    }
    
    public void novo() {
        pessoa = new Pessoa();
        pessoa.setEndereco(new Endereco());
        pessoa.getEndereco().setRua(new Rua());
        pessoa.getEndereco().setBairro(new Bairro());
        pessoa.getEndereco().setCidade(new Cidade());
        pessoa.getEndereco().setEstado(new Estado());
    }
    
    public String gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = getDao().gravar(pessoa);
        if(resultado) {
            novo();
            context.addMessage(null, new FacesMessage("Pessoa gravada com sucesso."));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar os dados da pessoa."));
        }
        
        return "list?faces-redirect=true";
    }

    public void selecionar() {
        pessoa = pessoas.getRowData();
    }
    
    public String alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = getDao().update(pessoa);
        if(resultado) {
            novo();
            context.addMessage(null, new FacesMessage("Pessoa alterada com sucesso."));
        } else {
            context.addMessage(null, new FacesMessage("Nao foi possivel alterar os dados da pessoa."));
        }
        return "list?faces-redirect=true";
    }
    
    public String remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        Pessoa pessoa = pessoas.getRowData();
        boolean resultado = getDao().remover(pessoa);
        if(resultado) {
            novo();
            context.addMessage(null, new FacesMessage("Pessoa excluida com sucesso."));
        } else {
            context.addMessage(null, new FacesMessage("Pessoa ao foi excluida."));
        }   
        
        return "list?faces-redirect=true";
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public DataModel<Pessoa> getPessoas() {
        List<Pessoa> pessoaList = pessoaDAO.listar();
        pessoas = new ListDataModel<>(pessoaList);
        return pessoas; 
    }
    
    public void setPessoas(DataModel<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    public Pessoa getPessoaById(int id) {
        return pessoa = getDao().selecionar(id);
    }
    
    public void selectRuaFromDialog(Rua rua) {
        pessoa.getEndereco().setRua(rua);
    }
    
    public void selectBairroFromDialog(Bairro bairro) {
        pessoa.getEndereco().setBairro(bairro);
    }
    
    public void selectEstadoFromDialog(Estado estado) {
        pessoa.getEndereco().setEstado(estado);
    }

    public void selectCidadeFromDialog(Cidade cidade) {
        pessoa.getEndereco().setCidade(cidade);
    }
    
}