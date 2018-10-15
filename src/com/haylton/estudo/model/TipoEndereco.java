package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Haylton
 */
@Table(name = "tipo_endereco")
@Entity
public class TipoEndereco implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_tipo_endereco", sequenceName = "seq_tipo_endereco", allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_endereco")
    private Integer id;
    @NotNull(message = "A descricao do tipo de endereco deve ser preenchida")
    @Length(max = 50, message = "O numero máximo de caracteres de descricao para tipo endereco eh {max}")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    public TipoEndereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
