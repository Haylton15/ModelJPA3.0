package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Haylton
 */
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED) //informa para jpa que essa classe pode oferecer herança com essa anotação @Inheritance  //a estratégia single_table é uma unica tabela pessoa, porem com atributos de pessoas jurifdicas e fisicas, caso quando for persistir for uma pessoa juridica, os atributos de pessoa fisica fica em branco.
@Entity
public class Pessoa implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa")
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 14, message = "O telefone não pode ter mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais de {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    //pq liste de telefone? Pq uma mesma pessoa pode ter mais de um telefone
    //pq orphanRemoval?ex:  quando você tem um carro em uma lista de carros relacionados a um concessionária. Se a concessionária for excluída, caso o carro não tenha vínculo com outras concessionárias será excluído também.
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Endereco> enderecos = new ArrayList<>();
    //o cascade ali em cima são as operações de persisterncia que serão propagadas para os filhos
    //Fetchtype.EAGER serve para que quando eu carregar a pessoa, eu carrego todos os endereços da pessoa, já o lazy eu carrego tardiamente a lista somente quando eu
    //relmente acessar a classe de enderecos que vai ser carregada. Ou seja, no caso da EAGER, se eu tenho 100 pessoas e cada uma tem 10 endereços, no total são 1000, vai pesar, agora com lazy eu acesso pessoa, carrega uma e seus 10 endereços

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
