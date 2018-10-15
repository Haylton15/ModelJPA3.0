package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Categoria;
import com.haylton.estudo.model.Marca;
import com.haylton.estudo.model.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePesistirProduto {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Produto produto = new Produto();
        produto.setCategoria(em.getReference(Categoria.class, 1));
        produto.setMarca(em.getReference(Marca.class, 4));
        produto.setNome("Iphone 8 Plus");
        produto.setPreco(5000D);
        produto.setQuantidadeEstoque(5D);
        produto.setDescricao("Smartphone totalmente inovador!");
        
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
}
