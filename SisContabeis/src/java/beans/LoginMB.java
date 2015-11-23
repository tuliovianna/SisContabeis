/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.LoginJpaController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Login;
import org.primefaces.context.RequestContext;

/**
 *
 * @author tulio
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisContabeisPU");
    LoginJpaController daoLogin = new LoginJpaController(factory);
    Login login = new Login();
    private boolean logado = false;
    private int admin = 0;
    
    public LoginMB() {
        logado = false;
    }
    
    public String logado() {
        List<Login> list = new ArrayList<Login>();
        list = daoLogin.findloginEntities();
        for(Login l: list) {
            if(login.getUsuario().equals(l.getUsuario()) && login.getSenha().equals(l.getSenha())) {
                logado = true;
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Bem vindo.");  
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                return "./solicitacoes.xhtml";
            } else {
                logado = false;
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Senha Incorreta.");  
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                return "./index.xhtml";
            }
        }
       return "./index.xhtml";
    }
   
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
        
    public String acesso() throws IOException {
        if(logado == false) {
           return "./index.xhtml";
        } else {
           return "./solicitacoes.xhtml"; 
        }
    } 
    
    public String returnLogin() {
        return "./faces/login.xhtml";
    }
    
    public boolean isLogado() {
        return logado;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
    
      
    
    
}
