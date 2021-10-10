import entity.Admin;

import javax.persistence.*;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();

            TypedQuery<String> query = entityManager.createQuery(
                    "SELECT a.username FROM Admin AS a", String.class);
            List<String> results = query.getResultList();

            System.out.println(results.get(0));

            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
