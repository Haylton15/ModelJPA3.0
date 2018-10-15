package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Categoria;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirCategoria {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Categoria categoria = new Categoria();
        categoria.setNome("Video Game");
        
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
    }
}
