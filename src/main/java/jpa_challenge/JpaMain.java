package jpa_challenge;

import jpa_challenge.domain.Book;
import jpa_challenge.domain.Order;
import jpa_challenge.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 *
 * @author snow
 * @since 2021/05/04
 */
public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 한번만 선언해야함

        EntityManager em = emf.createEntityManager(); // 사용하고 버려야됨, 쓰레드간 공유 x

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Book book =new Book();
            book.setName("JPA");
            book.setAuthor("섬인규");

            em.persist(book);

            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
