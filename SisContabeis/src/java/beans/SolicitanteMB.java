/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Mail;
import dao.CnaeJpaController;
import dao.EnderecoEstabelecimentoJpaController;
import dao.LoginJpaController;
import dao.SocioJpaController;
import dao.SolicitanteJpaController;
import dao.exceptions.NonexistentEntityException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cnae;
import modelo.DadosEmpresa;
import modelo.EnderecoEstabelecimento;
import modelo.Socio;
import modelo.Solicitante;
import org.apache.commons.mail.EmailException;
import org.primefaces.context.RequestContext;


/**
 *
 * @author tulio
 */
@ManagedBean
@SessionScoped 
public class SolicitanteMB  implements java.io.Serializable { 
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisContabeisPU");
    private SolicitanteJpaController daoSolicitante = new SolicitanteJpaController(factory);
    private EnderecoEstabelecimentoJpaController daoEndereco = new EnderecoEstabelecimentoJpaController(factory);
    private SocioJpaController daoSocio = new SocioJpaController(factory);
    private CnaeJpaController daoCnae = new CnaeJpaController(factory);
    private LoginJpaController daoLogin = new LoginJpaController(factory);
    private Solicitante solicitante = new Solicitante(); 
    private Mail email = new Mail();
    private String mensagemEmail = "";
    private Socio socio = new Socio();
    private List<Socio> socios = new ArrayList<Socio>(); 
    private List<Solicitante> solicitantes = new ArrayList<Solicitante>();
    private EnderecoEstabelecimento endereco = new EnderecoEstabelecimento();
    private DadosEmpresa dados = new DadosEmpresa();
    private String mensagem; 


    /**
     * Creates a new instance of SolicitanteMB
     */
    public SolicitanteMB() throws EmailException, MalformedURLException {
       
    }
    
    public String inserirSolicitacao() { 
       try {
           solicitante.setEndereco(endereco);
           solicitante.setDadosEmpresa(dados);
           solicitante.setStatus("Pendente"); 
           getDaoSolicitante().create(solicitante);
           email.enviarEmail(solicitante.getIdentificador(), solicitante.getNome(), dados.getOpcao1(), dados.getOpcao2(), dados.getOpcao3(), solicitante.getEmail());
           endereco = new EnderecoEstabelecimento();
           dados = new DadosEmpresa();
           solicitante = new Solicitante();
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Solicitação feita com sucesso.");  
           RequestContext.getCurrentInstance().showMessageInDialog(message);
           return "./index.xhtml";
       } catch (Exception ex) {
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Erro ao realizar solicitação.");  
           RequestContext.getCurrentInstance().showMessageInDialog(message);
           return "./index.xhtml";
       }
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void inserirSocio() {
        getSocios().add(socio);
        setSocio(new Socio()); 
        setMensagem("Sócio inserido com sucesso.");
    }
    
    
    public List<String> listaCnaes() {
        List<String> list = new ArrayList<String>();
        for(Cnae c: daoCnae.findCnaeEntities()) {
            list.add(c.getDescricao());
        }
        return list;  
    }
    
    public List<Solicitante> listaSolicitantes() {
        List<Solicitante> list = new ArrayList<Solicitante>();
        for(Solicitante s: getDaoSolicitante().findSolicitanteEntities()) {
            list.add(s); 
        }
        return list;  
    }
    
    public void validarSolicitacao() throws Exception {
        solicitante.setStatus("Aprovada.");
        daoSolicitante.edit(solicitante); 
        email.enviarEmailResposta(solicitante.getIdentificador(), solicitante.getNome(),
                solicitante.getDadosEmpresa().getOpcao1(), solicitante.getDadosEmpresa().getOpcao2(),
                solicitante.getDadosEmpresa().getOpcao3(), solicitante.getEmail(), solicitante.getStatus(), getMensagemEmail());
        mensagemEmail = "";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Validação feita com sucesso");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void negarSolicitacao() throws Exception {
        solicitante.setStatus("Negada.");
        daoSolicitante.edit(solicitante); 
        email.enviarEmailResposta(solicitante.getIdentificador(), solicitante.getNome(),
                solicitante.getDadosEmpresa().getOpcao1(), solicitante.getDadosEmpresa().getOpcao2(),
                solicitante.getDadosEmpresa().getOpcao3(), solicitante.getEmail(), solicitante.getStatus(), getMensagemEmail());
        mensagemEmail = "";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Negação feita com sucesso");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void excluirSolicitacoes() throws NonexistentEntityException {
        solicitantes =  getDaoSolicitante().findSolicitanteEntities();
        for (Solicitante s: solicitantes) {
             daoSolicitante.destroy(s.getId()); 
        }
        setMensagem("Solicitações excluidas com sucesso.");
    }
    
    public String textoEmail() {
        String msg = "";
        msg = solicitante.getNome().concat(solicitante.getNome());
        return msg;
    }
    
    public String redeSim() {
        return "./solicitante.xhtml";
    }
    
    public List<Solicitante> listSolicitantes() {
        solicitantes =  getDaoSolicitante().findSolicitanteEntities();
        return solicitantes;
    }
    
    /**
     * @return the daoUsuario
     */
    public SolicitanteJpaController getDaoUsuario() {
        return getDaoSolicitante();
    }

    /**
     * @param daoUsuario the daoUsuario to set
     */
    public void setDaoUsuario(SolicitanteJpaController daoUsuario) {
        this.setDaoSolicitante(daoUsuario);
    }

    /**
     * @return the solicitante
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param solicitante the solicitante to set
     */
    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String pagina2() {
        return "./segundo-passo.xhtml"; 
    }
    
    public String pagina1() {
        return "./solicitante.xhtml"; 
    }
    
    public String pagina3() {
       // if (!dados.getOpcao1().equals(dados.getOpcao2()) && !dados.getOpcao1().equals(dados.getOpcao3()) && !dados.getOpcao2().equals(dados.getOpcao3())) {
            return "./terceiro-passo.xhtml";
        //} else {
        //    setMensagem("Nenhuma das opções podem ser iguais."); 
        }
        //return "./segundo-passo.xhtml";
          
    public String pagina4() {
        if (!dados.getOpcao1().equals(dados.getOpcao2()) && !dados.getOpcao1().equals(dados.getOpcao3()) && !dados.getOpcao2().equals(dados.getOpcao3())) {
            return "./quarto-passo.xhtml";
        } else {
            setMensagem("Nenhuma das opções podem ser iguais."); 
        }
        setMensagem("Nenhuma das opções podem ser iguais."); 
        return "./terceiro-passo.xhtml";
    }
        
    public String inicio() {
        return "./index.xhtml";
    }
    
    public List<String> list() {
        List<String> list = new ArrayList<String>();
        return list;
    }
    
    /**
     * @return the socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * @return the endereco
     */
    public EnderecoEstabelecimento getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(EnderecoEstabelecimento endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the dados
     */
    public DadosEmpresa getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(DadosEmpresa dados) {
        this.dados = dados;
    }

    /**
     * @return the email
     */
    public Mail getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Mail email) {
        this.email = email;
    }

    /**
     * @return the daoSolicitante
     */
    public SolicitanteJpaController getDaoSolicitante() {
        return daoSolicitante;
    }

    /**
     * @param daoSolicitante the daoSolicitante to set
     */
    public void setDaoSolicitante(SolicitanteJpaController daoSolicitante) {
        this.daoSolicitante = daoSolicitante;
    }

    /**
     * @return the daoEndereco
     */
    public EnderecoEstabelecimentoJpaController getDaoEndereco() {
        return daoEndereco;
    }

    /**
     * @param daoEndereco the daoEndereco to set
     */
    public void setDaoEndereco(EnderecoEstabelecimentoJpaController daoEndereco) {
        this.daoEndereco = daoEndereco;
    }

    /**
     * @return the daoSocio
     */
    public SocioJpaController getDaoSocio() {
        return daoSocio;
    }

    /**
     * @param daoSocio the daoSocio to set
     */
    public void setDaoSocio(SocioJpaController daoSocio) {
        this.daoSocio = daoSocio;
    }

    /**
     * @return the socios
     */
    public List<Socio> getSocios() {
        return socios;
    }

    /**
     * @param socios the socios to set
     */
    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    /**
     * @return the solicitantes
     */
    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    /**
     * @param solicitantes the solicitantes to set
     */
    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public String getMensagemEmail() {
        return mensagemEmail;
    }

    public void setMensagemEmail(String mensagemEmail) {
        this.mensagemEmail = mensagemEmail;
    }

   
    
     
}
