package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Pais;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirPais {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais pais = new Pais();
        
        pais.setIso("EUA");
        pais.setNome("United States of America");
        
        em.getTransaction().begin();
        em.persist(pais);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
