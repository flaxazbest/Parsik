package ua.azbest.dao;

import ua.azbest.part.Videocard;

import java.util.List;

public class VideocardDAO {

    public static void create(List<Videocard> list) {
        org.hibernate.Session session = HibernateUtilites.getSessionFactory().openSession();
        session.beginTransaction();
        for (Videocard v: list)
            session.save(v);
        session.getTransaction().commit();
        session.close();
    }

}
