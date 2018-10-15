package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Estado;
import com.haylton.estudo.model.Pais;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirEstado {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Estado estado = new Estado();
        estado.setNome("Distrito Federal");
        estado.setUf("DF");
        estado.setPais(em.getReference(Pais.class, 1));
        
        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();
        em.close();
        
    }
}
