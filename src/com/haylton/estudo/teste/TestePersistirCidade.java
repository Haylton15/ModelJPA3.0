package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Cidade;
import com.haylton.estudo.model.Estado;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirCidade {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Cidade cidade = new Cidade();
        cidade.setNome("Planaltina");
        cidade.setEstado(em.getReference(Estado.class, 1));
        
        em.getTransaction().begin();
        em.persist(cidade);
        em.getTransaction().commit();
        em.close();
        
    }
}
