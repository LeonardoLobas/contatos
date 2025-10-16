package br.com.fiap.contatos;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContatoApp {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Kevin Luan Damm");
        contato.setEmail("kevin@gmail.com");
        contato.setDataNascimento(LocalDate.of(2003, 11, 25));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
