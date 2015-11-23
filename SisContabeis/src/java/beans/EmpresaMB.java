/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DadosEmpresaJpaController;
import dao.SolicitanteJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.DadosEmpresa;

/**
 *
 * @author tulio
 */
@ManagedBean
@SessionScoped
public class EmpresaMB implements java.io.Serializable {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisContabeisPU");
    private DadosEmpresaJpaController daoEmpresa = new DadosEmpresaJpaController(factory);
    private DadosEmpresa dadosEmpresa = new DadosEmpresa(); 
    private String mensagem = ""; 
    
    public EmpresaMB() {
    }

    /**
     * @return the dadosEmpresa
     */
    public DadosEmpresa getDadosEmpresa() {
        return dadosEmpresa;
    }

    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param dadosEmpresa the dadosEmpresa to set
     */
    public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
        this.dadosEmpresa = dadosEmpresa;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
       
    
    
}
