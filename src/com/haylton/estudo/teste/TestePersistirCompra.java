package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Compra;
import com.haylton.estudo.model.CompraID;
import com.haylton.estudo.model.CompraItem;
import com.haylton.estudo.model.PessoaJuridica;
import com.haylton.estudo.model.Produto;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirCompra {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Compra compra = new Compra();
        Produto produto = em.getReference(Produto.class, 2);
        PessoaJuridica pj = em.getReference(PessoaJuridica.class, 7);
        CompraID compraID = new CompraID();
        compraID.setPessoaJuridica(pj);
        compraID.setNumeroNota(1234567);
        CompraItem compraItem = new CompraItem();
        compraItem.setCompra(compra);
        compraItem.setProduto(produto);
        compraItem.setQuantidade(10D);
        compraItem.setValorUnitario(produto.getPreco());
        compraItem.setValorTotal(compraItem.getValorUnitario() * compraItem.getQuantidade());
        compra.setDataCompra(Calendar.getInstance());
        compra.setCompraID(compraID);
        compra.adicionarItem(compraItem);

        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
    }
}
