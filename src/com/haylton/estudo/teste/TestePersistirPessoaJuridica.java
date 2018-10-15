package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.PessoaJuridica;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirPessoaJuridica {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj("52098958000160");
        pj.setEmail("empresajunior@gmail.com");
        pj.setIe("426465723018");
        pj.setNome("Empresa Junior");
        pj.setTelefone("(61)36375481");
        
        em.getTransaction().begin();
        em.persist(pj);
        em.getTransaction().commit();
        em.close();
    }
    
}
