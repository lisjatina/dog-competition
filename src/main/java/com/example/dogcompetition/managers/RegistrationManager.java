package com.example.dogcompetition.managers;

import com.example.dogcompetition.data.Participant;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegistrationManager {

    private static SessionFactory factory;

    public RegistrationManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(Participant.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // метод для записи в базу данных
    public void save(Object item){

        // создаем сессию - подключение к базе данных
        var session = factory.openSession();
        // создаем транзакцию - список запросов к базе данных. Если хотя бы один из запросов рухнет, то никакие
        // изменения не будут записаны в базу
        Transaction tx = null;

        try {
            // запускаем сессию
            tx = session.beginTransaction();
            // сохраняем объект
            session.save(item);
            // если сохранился успешно, отправляем изменения в базу данных.
            // В рамках одной транзакции можно вносить сколько угодно изменений
            tx.commit();
//если что-то пошло не так и поймали ошибку, то проверяем
        } catch (HibernateException exception) {
            // есть ли в принципе действующая сессия (подключение к базе). Если сессия есть, то
            if(tx !=null){
                //откатываем все изменения, так как одно или несколько не прошло
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            //обязательно закрываем сессию
            session.close();
        }
    }
}
