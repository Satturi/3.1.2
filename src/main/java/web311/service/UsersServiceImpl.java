package web311.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import web311.dao.DAO;
import web311.models.Users;


import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl {

    private final DAO dao;


    public UsersServiceImpl(DAO dao) {
        this.dao = dao;
    }
    @Transactional(readOnly = true)
    public List<Users> index() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public Users show(int id) {
        Optional<Users> foundPerson = dao.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Users user) {
        dao.save(user);
    }

    @Transactional
    public void delete(int id) {
        dao.deleteById(id);
    }

    @Transactional
    public void update(int id, Users user) {
        user.setId(id);
        dao.save(user);
    }
}
