package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Cidade;
import com.haylton.estudo.model.Estado;
import com.haylton.estudo.model.Permissao;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirPermissao {
    public static void main(String[] args) {
         EntityManager em = EntityManagerUtil.getEntityManager();
        Permissao permissao = new Permissao();
        permissao.setNome("USER");
        permissao.setDescricao("Usuário do Sistema");
        em.getTransaction().begin();
        em.persist(permissao);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
