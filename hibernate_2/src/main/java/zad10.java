import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class zad10 {
    public static void main(String[] args){
        Scanner abv = new Scanner(System.in);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createNativeQuery("select * from employees", Employee.class).getResultList();

        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Engineering")
            || employee.getDepartment().getName().equals("Tool Design")
            || employee.getDepartment().getName().equals("Marketing")
            || employee.getDepartment().getName().equals("Information Services"))
            {
                double newSalary = employee.getSalary().intValue()*1.12;
                employee.setSalary(new BigDecimal(newSalary));
                System.out.println(employee.getFirstName() + " "
                + employee.getLastName() + " "
                + "(" + employee.getSalary() + ")");
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
