package com.example.dogcompetition.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserRepository {
    private static SessionFactory factory;

    public User login(String email, String password) {
        var session = factory.openSession();

        try {
            String hql = "FROM User U WHERE U.email = :email and U.password = MD5(:pwd)";
            Query query = session.createQuery(hql);

            query.setParameter("email", email);
            query.setParameter("pwd", password);

            var results = query.list();

            if (results.size() > 0) {
                return (User) results.get(0);
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return null;
    }

}
