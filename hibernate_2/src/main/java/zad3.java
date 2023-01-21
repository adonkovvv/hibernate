import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class zad3 {
    public static void main(String[] args){
        Scanner abv = new Scanner(System.in);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        String[] line = abv.nextLine().split(" ");

        List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();

        boolean flag = false;

        for (Employee empl : employees) {
            if (empl.getFirstName().equals(line[0]) && empl.getLastName().equals(line[1]))
            {
                System.out.println("True");
                flag = true;
                break;
            }
        }

        if (!flag)
        {
            System.out.println("False");
        }

        em.getTransaction().commit();
        em.close();
    }
}
