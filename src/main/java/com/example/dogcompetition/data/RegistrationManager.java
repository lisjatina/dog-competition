package com.example.dogcompetition.data;
import com.example.dogcompetition.dto.RegistrationDto;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegistrationManager {

    private static SessionFactory factory;

    public RegistrationManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(Handler.class)
                    .addAnnotatedClass(Dog.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // метод для записи в базу данных и mapping DTO (Dog, Handler и автоматическая запись в таблицу с будущими результатами) на две (три?) разные таблицы
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
            session.close();
        }
    }

    // одним методом сохраняю сразу с хендлера и собаку. Можно ли так?
    public void saveParticipant(RegistrationDto dto){
        var session = factory.openSession();
        Transaction tx = null;
        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogBreed(), dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), handler);
        try {
            tx = session.beginTransaction();

            session.save(handler);
            session.save(dog);
            tx.commit();

        } catch (HibernateException exception) {
            if(tx !=null){
            tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }
}
