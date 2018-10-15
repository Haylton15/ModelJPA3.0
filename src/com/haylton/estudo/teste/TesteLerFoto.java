/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.estudo.teste;

import com.haylton.estudo.jpa.EntityManagerUtil;
import com.haylton.estudo.model.Foto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
public class TesteLerFoto {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Foto foto = em.getReference(Foto.class, 1);
        File file = new File("C:\\Desenvolvimento\\Java\\Libs\\galaxy-s8.jpg");
        FileOutputStream out = new FileOutputStream(file);
        out.write(foto.getArquivo());
        out.close();
    }
}
