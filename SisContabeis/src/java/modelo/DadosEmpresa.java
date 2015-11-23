/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class DadosEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String naturezaJuridica;
    
    private String eventoConsulta;
    
    private String cidadeEmpresa;
    
    private String opcao1;
    
    private String opcao2;
    
    private String opcao3;
        
    private String enquadramento;
    
    private String descricao;
    
    private String numeroInscricao;
    
    private String codCnaePrincipal;
    
    private String cnaePrincipal;
    
    private String cnaeSecundario;
    
     private String codCnaeSecundario;
    
    private String tipoUnidade;
    
    private String formaAtuacao;
    
    private String formaAtuacao2;
    
    private String formaAtuacao3;
    
    private String formaAtuacao4;
    
    private String formaAtuacao5;
    
    private String formaAtuacao6;
    
    private String formaAtuacao7;
    
    
    
    

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
        if (!(object instanceof DadosEmpresa)) {
            return false;
        }
        DadosEmpresa other = (DadosEmpresa) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public void adicionarSocios() {
        
    }

    @Override
    public String toString() {
        return "modelo.DadosEmpresa[ id=" + getId() + " ]";
    }

    /**
     * @return the naturezaJuridica
     */
    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    /**
     * @param naturezaJuridica the naturezaJuridica to set
     */
    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    /**
     * @return the eventoConsulta
     */
    public String getEventoConsulta() {
        return eventoConsulta;
    }

    /**
     * @param eventoConsulta the eventoConsulta to set
     */
    public void setEventoConsulta(String eventoConsulta) {
        this.eventoConsulta = eventoConsulta;
    }

    /**
     * @return the cidadeEmpresa
     */
    public String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    /**
     * @param cidadeEmpresa the cidadeEmpresa to set
     */
    public void setCidadeEmpresa(String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa;
    }

    /**
     * @return the opcao1
     */
    public String getOpcao1() {
        return opcao1;
    }

    /**
     * @param opcao1 the opcao1 to set
     */
    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    /**
     * @return the opcao2
     */
    public String getOpcao2() {
        return opcao2;
    }

    /**
     * @param opcao2 the opcao2 to set
     */
    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    /**
     * @return the opcao3
     */
    public String getOpcao3() {
        return opcao3;
    }

    /**
     * @param opcao3 the opcao3 to set
     */
    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }
    
    /**
     * @return the enquadramento
     */
    public String getEnquadramento() {
        return enquadramento;
    }

    /**
     * @param enquadramento the enquadramento to set
     */
    public void setEnquadramento(String enquadramento) {
        this.enquadramento = enquadramento;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipoUnidade
     */
    public String getTipoUnidade() {
        return tipoUnidade;
    }

    /**
     * @param tipoUnidade the tipoUnidade to set
     */
    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    /**
     * @return the formaAtuacao
     */
    public String getFormaAtuacao() {
        return formaAtuacao;
    }

    /**
     * @param formaAtuacao the formaAtuacao to set
     */
    public void setFormaAtuacao(String formaAtuacao) {
        this.formaAtuacao = formaAtuacao;
    }

    /**
     * @return the numeroInscricao
     */
    public String getNumeroInscricao() {
        return numeroInscricao;
    }

    /**
     * @param numeroInscricao the numeroInscricao to set
     */
    public void setNumeroInscricao(String numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    /**
     * @return the formaAtuacao2
     */
    public String getFormaAtuacao2() {
        return formaAtuacao2;
    }

    /**
     * @param formaAtuacao2 the formaAtuacao2 to set
     */
    public void setFormaAtuacao2(String formaAtuacao2) {
        this.formaAtuacao2 = formaAtuacao2;
    }

    /**
     * @return the formaAtuacao3
     */
    public String getFormaAtuacao3() {
        return formaAtuacao3;
    }

    /**
     * @param formaAtuacao3 the formaAtuacao3 to set
     */
    public void setFormaAtuacao3(String formaAtuacao3) {
        this.formaAtuacao3 = formaAtuacao3;
    }

    /**
     * @return the formaAtuacao4
     */
    public String getFormaAtuacao4() {
        return formaAtuacao4;
    }

    /**
     * @param formaAtuacao4 the formaAtuacao4 to set
     */
    public void setFormaAtuacao4(String formaAtuacao4) {
        this.formaAtuacao4 = formaAtuacao4;
    }

    /**
     * @return the formaAtuacao5
     */
    public String getFormaAtuacao5() {
        return formaAtuacao5;
    }

    /**
     * @param formaAtuacao5 the formaAtuacao5 to set
     */
    public void setFormaAtuacao5(String formaAtuacao5) {
        this.formaAtuacao5 = formaAtuacao5;
    }

    /**
     * @return the formaAtuacao6
     */
    public String getFormaAtuacao6() {
        return formaAtuacao6;
    }

    /**
     * @param formaAtuacao6 the formaAtuacao6 to set
     */
    public void setFormaAtuacao6(String formaAtuacao6) {
        this.formaAtuacao6 = formaAtuacao6;
    }

    /**
     * @return the formaAtuacao7
     */
    public String getFormaAtuacao7() {
        return formaAtuacao7;
    }

    /**
     * @param formaAtuacao7 the formaAtuacao7 to set
     */
    public void setFormaAtuacao7(String formaAtuacao7) {
        this.formaAtuacao7 = formaAtuacao7;
    }

    /**
     * @return the cnaePrincipal
     */
    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    /**
     * @param cnaePrincipal the cnaePrincipal to set
     */
    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    /**
     * @return the codCnaeSecundario
     */
    public String getCodCnaeSecundario() {
        return codCnaeSecundario;
    }

    /**
     * @param codCnaeSecundario the codCnaeSecundario to set
     */
    public void setCodCnaeSecundario(String codCnaeSecundario) {
        this.codCnaeSecundario = codCnaeSecundario;
    }

    /**
     * @return the codCnaePrincipal
     */
    public String getCodCnaePrincipal() {
        return codCnaePrincipal;
    }

    /**
     * @param codCnaePrincipal the codCnaePrincipal to set
     */
    public void setCodCnaePrincipal(String codCnaePrincipal) {
        this.codCnaePrincipal = codCnaePrincipal;
    }

    /**
     * @return the cnaeSecundario
     */
    public String getCnaeSecundario() {
        return cnaeSecundario;
    }

    /**
     * @param cnaeSecundario the cnaeSecundario to set
     */
    public void setCnaeSecundario(String cnaeSecundario) {
        this.cnaeSecundario = cnaeSecundario;
    }
    
}
