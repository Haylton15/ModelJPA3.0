package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Haylton
 */
@Table(name = "parcela")
@Entity
public class Parcela implements Serializable{
    @EmbeddedId
    private ParcelaID parcelaID;
    
    @NotNull(message = "O valor da parcela deve ser informado")
    @Min(value = 0, message = "O valor da parcela não pode ser negativo")
    @Column(name = "valor_parcela", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorParcela;
    
    @NotNull(message = "A data de vencimento deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    
    @Min(value = 0, message = "O valor do pagamento não pode ser negativo")
    @Column(name = "valor_pagamento", columnDefinition = "decimal(12,2)")
    private Double valorPagamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pagamento")
    private Calendar dataPagamento;

    public Parcela() {
    }
    
    
    public ParcelaID getParcelaID() {
        return parcelaID;
    }

    public void setParcelaID(ParcelaID parcelaID) {
        this.parcelaID = parcelaID;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.parcelaID);
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
        final Parcela other = (Parcela) obj;
        if (!Objects.equals(this.parcelaID, other.parcelaID)) {
            return false;
        }
        return true;
    }
    
    
    
}
