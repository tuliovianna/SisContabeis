/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author tulio
 */
@Entity
public class Solicitante implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String identificador;
    
    private String nome;
    
    private String contador;
    
    private String telefone;
    
    private String email;
    
    private String status;
    
    @OneToOne (cascade = CascadeType.ALL)
    private EnderecoEstabelecimento endereco;
    
    @OneToMany(mappedBy="solicitante") 
    private List<Socio> socio;
    
    @OneToOne (cascade=CascadeType.ALL)
    private DadosEmpresa dadosEmpresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitante)) {
            return false;
        }
        Solicitante other = (Solicitante) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solicitante[ id=" + getId() + " ]";
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the contador
     */
    public String getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(String contador) {
        this.contador = contador;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the dadosEmpresa
     */
    public DadosEmpresa getDadosEmpresa() {
        return dadosEmpresa;
    }

    /**
     * @param dadosEmpresa the dadosEmpresa to set
     */
    public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
        this.dadosEmpresa = dadosEmpresa;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the socio
     */
    public List<Socio> getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(List<Socio> socio) {
        this.socio = socio;
    }
    
}
