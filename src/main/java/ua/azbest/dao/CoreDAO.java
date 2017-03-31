package ua.azbest.dao;

import ua.azbest.part.Stone;

import java.util.List;

public class CoreDAO {

    public static void create(List<Stone> list) {
        org.hibernate.Session session = HibernateUtilites.getSessionFactory().openSession();
        session.beginTransaction();
        for (Stone s: list)
            session.save(s);
        session.getTransaction().commit();
        session.close();
    }

}
