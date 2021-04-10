package com.example.dogcompetition.data;
import com.example.dogcompetition.dto.ParticipantDto;
import com.example.dogcompetition.dto.RegistrationDto;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static SessionFactory factory;
    private Course course;

    public DatabaseManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(Handler.class)
                    .addAnnotatedClass(Dog.class)
                    .addAnnotatedClass(Breed.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // метод для записи в базу данных и mapping DTO (Dog, Handler и автоматическая запись в таблицу с будущими результатами) на две (три?) разные таблицы
    public void save(List <Object> items){

        // создаем сессию - подключение к базе данных
        var session = factory.openSession();
        // создаем транзакцию - список запросов к базе данных. Если хотя бы один из запросов рухнет, то никакие
        // изменения не будут записаны в базу
        Transaction tx = null;

        try {
            // запускаем сессию
            tx = session.beginTransaction();
            // сохраняем объект
            for ( var item: items
                 ) {
             session.save(item);
            }
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
            session.close();
        }
    }

    public List<Breed> getBreeds(){
       var session = factory.openSession();

            try {
                return session.createQuery("FROM Breed").list();
            } catch (HibernateException exception) {
                System.err.println(exception);
            } finally {
                session.close();
            }
            return new ArrayList<>();
        }

    public List<Dog> getDogs(){
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Dog").list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

// TODO: 4/10/2021
//    public void startCompetition(ParticipantDto participantDto, Integer length, Double speed){
//        List <ParticipantDto> currentParticipants = getParticipants();
//        course = new Course(length, speed);
//        var standardTime = course.calculateStandardTime(); // надо записать значение в базу и отобразить в html
//        var maxTime = course.calculateMaxTime(); // надо записать значение в базу и отобразить в html
//        course.calculateResult(participantDto); // надо записать значение в базу и отобразить в html
//    }


}
