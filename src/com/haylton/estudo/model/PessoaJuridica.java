package com.haylton.estudo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Haylton
 */
@Table(name = "pessoa_juridica")
@Entity
public class PessoaJuridica extends Pessoa implements Serializable{
    @NotNull(message="O IE não pode ser nulo")
    @NotBlank(message="O IE deve ser preenchido")
    @Length(max = 12, message = "O IE não pode ter mais de {max} caracteres")
    @Column(name="ie",length = 12, nullable = false)
    private String ie;
    
    @NotNull(message="O CNPJ não pode ser nulo")
    @NotBlank(message="O CNPJ deve ser preenchido")
    @CNPJ(message = "O cnpj deve ser válido")
    @Column(name="cnpj",length = 14, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
