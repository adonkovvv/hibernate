import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class zad2 {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Town> resultList = em.createQuery("select t from Town t", Town.class).getResultList();

        for (Town town : resultList) {
                if (town.getName() != null && town.getName().length() > 5) {
                    town.setName(town.getName().toUpperCase(Locale.ROOT));
                    em.persist(town);
                }
        }

        em.getTransaction().commit();
        em.close();
    }
}
