package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DadosEmpresa;
import modelo.EnderecoEstabelecimento;
import modelo.Socio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-23T15:52:25")
@StaticMetamodel(Solicitante.class)
public class Solicitante_ { 

    public static volatile SingularAttribute<Solicitante, String> telefone;
    public static volatile SingularAttribute<Solicitante, DadosEmpresa> dadosEmpresa;
    public static volatile SingularAttribute<Solicitante, EnderecoEstabelecimento> endereco;
    public static volatile SingularAttribute<Solicitante, String> contador;
    public static volatile ListAttribute<Solicitante, Socio> socio;
    public static volatile SingularAttribute<Solicitante, String> nome;
    public static volatile SingularAttribute<Solicitante, Long> id;
    public static volatile SingularAttribute<Solicitante, String> email;
    public static volatile SingularAttribute<Solicitante, String> identificador;
    public static volatile SingularAttribute<Solicitante, String> status;

}