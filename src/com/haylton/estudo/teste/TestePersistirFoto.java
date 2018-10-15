package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Foto;
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
public class TestePersistirFoto {
    public static void main(String[] args) throws IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Produto produto = em.getReference(Produto.class, 1);
        Foto foto = new Foto();
        foto.setNome("galaxy-s9.jpg");
        foto.setDescricao(produto.getDescricao());
        Path path = Paths.get("C:\\Desenvolvimento\\Java\\Libs\\"+foto.getNome());
        foto.setArquivo(Files.readAllBytes(path));
        produto.adicionarFoto(foto);
        
        em.getTransaction().begin();
        em.persist(foto);
        em.getTransaction().commit();
        
    }
}
