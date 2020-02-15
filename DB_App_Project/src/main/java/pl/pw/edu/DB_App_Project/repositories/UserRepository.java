package pl.pw.edu.DB_App_Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.User;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> getUserByUsername(String username);

}
