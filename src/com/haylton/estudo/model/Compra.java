/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Haylton
 */
@Table(name = "compra")
@Entity
public class Compra implements Serializable{
    
    @EmbeddedId
    private CompraID compraID;
    @NotNull(message = "A data da compra deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_compra", nullable = false)
    private Calendar dataCompra;
    
    @NotNull(message = "O valor total não pode ser nulo")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CompraItem> compraItems = new ArrayList<>();

    public Compra() {
        valorTotal = 0.0;
    }
    public void adicionarItem(CompraItem item){
        item.setCompra(this); //incluo primeiro a compra no compraItem
        valorTotal += item.getValorTotal(); // pego o valor total de todos os items da compra
        this.compraItems.add(item); // e adiciono a lista de compraItem o item
    }
    
    public void removerItem(int index){
        CompraItem item = (CompraItem) this.compraItems.get(index);
        valorTotal -= item.getValorTotal();
        this.compraItems.remove(index);
    }

    public CompraID getCompraID() {
        return compraID;
    }

    public void setCompraID(CompraID compraID) {
        this.compraID = compraID;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<CompraItem> getCompraItems() {
        return compraItems;
    }

    public void setCompraItems(List<CompraItem> compraItems) {
        this.compraItems = compraItems;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.compraID);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.compraID, other.compraID)) {
            return false;
        }
        return true;
    }
    
    
    
}
