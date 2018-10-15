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
@Table(name="cidade")
@Entity
public class Cidade implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade")
    private Integer id;
    
    @Length(max = 50, message = "O nome da cidade não pde passar de {max} caracteres")
    @NotNull(message = "O nome da cidade não pode ser vazio")
    @NotBlank(message="O nome da cidade deve ser preenchido")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_estado")
    private Estado estado;

    public Cidade() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
