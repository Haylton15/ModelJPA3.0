package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Pais;
import com.haylton.estudo.model.TipoEndereco;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirTipoEndereco {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        TipoEndereco tipoEnd = new TipoEndereco();
        
        tipoEnd.setDescricao("AVENIDA");
        
        
        em.getTransaction().begin();
        em.persist(tipoEnd);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
