import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class zad4 {
    public static void main(String[] args){
        Scanner abv = new Scanner(System.in);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();

        for (Employee employee : employees) {
            if (employee.getSalary().intValue() > 50000)
            {
                System.out.println(employee.getFirstName());
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
