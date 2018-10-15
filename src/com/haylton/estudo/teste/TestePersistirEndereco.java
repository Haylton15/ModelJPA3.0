package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Cidade;
import com.haylton.estudo.model.Endereco;
import com.haylton.estudo.model.PessoaFisica;
import com.haylton.estudo.model.TipoEndereco;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirEndereco {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Endereco endereco = new Endereco();
        endereco.setBairro("Setor norte");
        endereco.setCep("75731207");
        endereco.setCidade(em.getReference(Cidade.class, 1));
        endereco.setComplemento("casa");
        endereco.setEndereco("qd a 06 mar");
        endereco.setReferencia("mercado");
        endereco.setNickname("num sei");
        endereco.setNumero("06");
        endereco.setPessoa(em.getReference(PessoaFisica.class, 1));
        endereco.setTipoEndereco(em.getReference(TipoEndereco.class, 1));
        
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
