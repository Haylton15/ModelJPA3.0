package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.PessoaFisica;
import com.haylton.estudo.model.Produto;
import com.haylton.estudo.model.Venda;
import com.haylton.estudo.model.VendaItem;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirVenda {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Produto produto = em.getReference(Produto.class, 1);
        PessoaFisica pf = em.getReference(PessoaFisica.class, 1);
        Venda venda = new Venda();
        venda.setDataVenda(Calendar.getInstance());
        venda.setParcelas(3);
        venda.setPessoaFisica(pf);
        VendaItem vendaItem = new VendaItem();
        vendaItem.setProduto(produto);
        vendaItem.setQuantidadeItem(5.00);
        vendaItem.setValorUnitario(produto.getPreco());
        vendaItem.setValorTotal(vendaItem.getQuantidadeItem() * vendaItem.getValorUnitario());
        venda.adicionarItem(vendaItem);
        venda.gerarParcelas();
        
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }
}
