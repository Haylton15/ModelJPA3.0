/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Haylton
 */
@Table(name="estado")
@Entity
public class Estado implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado")
    private Integer id;
    
    @Length(max =50, message = "O valor não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome do estado deve ser informado")
    @NotNull(message = "O nome do estado não pode ser nulo")
    @Column(name="nome", nullable = false, length = 50)
    private String nome;
    
    @Length(max =2, message = "O valor não pode ter mais de {max} caracteres")
    @NotBlank(message = "A UF deve ser informada")
    @NotNull(message = "A UF  não pode ser nula")
    @Column(name="uf", nullable = false, length = 50)
    private String uf;
    @NotNull(message = "O pais deve ser informado")
    @ManyToOne
    @JoinColumn(name="pais", referencedColumnName = "id", nullable = false )//name referencia  a coluna pais em estado, referencedColumnName que referencia a coluna id na tabela pais
    @ForeignKey(name= "fk_pais")
    private Pais pais;

    public Estado() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
