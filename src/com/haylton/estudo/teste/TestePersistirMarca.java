package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Categoria;
import com.haylton.estudo.model.Marca;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirMarca {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Marca marca = new Marca();
        marca.setNome("Lg");
        
        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();
        em.close();
    }
}
