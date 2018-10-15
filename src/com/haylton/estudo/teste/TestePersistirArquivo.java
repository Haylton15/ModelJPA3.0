/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Arquivo;
import com.haylton.estudo.model.Produto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TestePersistirArquivo {
    public static void main(String[] args) throws IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Produto produto = em.getReference(Produto.class, 1);
        Arquivo arquivo = new Arquivo();
        arquivo.setNome("Galaxy s9");
        arquivo.setDescricao(produto.getDescricao());
        produto.adicionarArquivo(arquivo);
        Path path = Paths.get("C:\\Desenvolvimento\\Java\\Libs\\CadastroClientes.png");
        arquivo.setArquivo(Files.readAllBytes(path));
        
        em.getTransaction().begin();
        em.persist(arquivo);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
