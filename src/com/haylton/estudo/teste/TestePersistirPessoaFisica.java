/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Cidade;
import com.haylton.estudo.model.Endereco;
import com.haylton.estudo.model.Permissao;
import com.haylton.estudo.model.PessoaFisica;
import com.haylton.estudo.model.TipoEndereco;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirPessoaFisica {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("630.695.060-54");
        pf.setEmail("haylton2012@gmail.com");
    
        pf.setNascimento(Calendar.getInstance());
        pf.setNome("Haylton Rodrigues");
        pf.setNomeUsuario("HayltonDev");
        
        pf.getPermissoes().add(em.getReference(Permissao.class, "ADM"));
        pf.setRg("3305647");
        pf.setSenha("123456789");
        pf.setTelefone("(61)993142336");
        
        em.getTransaction().begin();
//        em.persist(enderecos);
//        em.persist(per);
        em.persist(pf);
        em.getTransaction().commit();
        em.close();
    }
    
}
