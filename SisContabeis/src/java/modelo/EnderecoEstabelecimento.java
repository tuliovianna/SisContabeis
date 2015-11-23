/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tulio
 */
@Entity
public class EnderecoEstabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String cep;
    
    private String tipoLogradouro;
    
    private String tipoImovel;
    
    private String bairro;
    
    private String endereco;
    
    private String numero;
    
    private String complemento;
    
    private double metragem;
    
    private String pontoReferencia;
    
    private String naturezaImovel;
    
    private String inscricaoImovel;

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
        if (!(object instanceof EnderecoEstabelecimento)) {
            return false;
        }
        EnderecoEstabelecimento other = (EnderecoEstabelecimento) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Endereco[ id=" + getId() + " ]";
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the tipoLogradouro
     */
    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    /**
     * @param tipoLogradouro the tipoLogradouro to set
     */
    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    /**
     * @return the tipoImovel
     */
    public String getTipoImovel() {
        return tipoImovel;
    }

    /**
     * @param tipoImovel the tipoImovel to set
     */
    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the metragem
     */
    public double getMetragem() {
        return metragem;
    }

    /**
     * @param metragem the metragem to set
     */
    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    /**
     * @return the pontoReferencia
     */
    public String getPontoReferencia() {
        return pontoReferencia;
    }

    /**
     * @param pontoReferencia the pontoReferencia to set
     */
    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    /**
     * @return the naturezaImovel
     */
    public String getNaturezaImovel() {
        return naturezaImovel;
    }

    /**
     * @param naturezaImovel the naturezaImovel to set
     */
    public void setNaturezaImovel(String naturezaImovel) {
        this.naturezaImovel = naturezaImovel;
    }

    /**
     * @return the inscricaoImovel
     */
    public String getInscricaoImovel() {
        return inscricaoImovel;
    }

    /**
     * @param inscricaoImovel the inscricaoImovel to set
     */
    public void setInscricaoImovel(String inscricaoImovel) {
        this.inscricaoImovel = inscricaoImovel;
    }
    
}
