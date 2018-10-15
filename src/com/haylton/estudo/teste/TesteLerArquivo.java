package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TesteLerArquivo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Arquivo arquivo = em.getReference(Arquivo.class, 1);
        File file = new File("C:\\Desenvolvimento\\Java\\Libs\\TesteLerArquivo.png");
        FileOutputStream out = new FileOutputStream(file);
        out.write(arquivo.getArquivo());
        out.close();
    }
}
