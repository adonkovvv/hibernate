import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class zad9 {
    public static void main(String[] args){
        Scanner abv = new Scanner(System.in);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Project> projects = em.createNativeQuery("select * from projects order by start_date desc limit 10", Project.class).getResultList();

        //Project name: All-Purpose Bike Stand
        //Project Description: Research, design and development of …
        //Project Start Date:2005-09-01 00:00:00.0
        //Project End Date: null

        projects = projects.stream().sorted(Comparator.comparing(project -> project.getName())).collect(Collectors.toList());

        for (Project project : projects) {
            System.out.println("Project name: " + project.getName() + "\n" + "Project Description: " + project.getDescription()
            + "\n" + "Project Start Date:" + project.getStartDate() + "\n" + "Project End Date: " + project.getEndDate());
        }

        em.getTransaction().commit();
        em.close();
    }
}
