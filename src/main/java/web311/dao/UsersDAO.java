package web311.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import web311.models.Users;

import java.util.List;


@Component

public class UsersDAO implements DAO{

    private final SessionFactory sessionFactory;


    public UsersDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Users> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Users p", Users.class)
                .getResultList();
    }
    @Override
    public Users show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Users.class, id);
    }
    @Override
    public void save(Users person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }
    @Override
    public void update(int id, Users updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Users personToBeUpdated = session.get(Users.class, id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Users.class, id));
    }
}
