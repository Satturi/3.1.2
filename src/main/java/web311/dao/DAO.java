package web311.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web311.models.Users;

@Repository
public interface DAO extends JpaRepository<Users, Integer> {

}
