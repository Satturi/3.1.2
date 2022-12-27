package web311.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web311.models.Users;

import java.util.List;

public interface DAO extends JpaRepository<Users, Integer> {

}