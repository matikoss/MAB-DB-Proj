package pl.pw.edu.DB_App_Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.DB_App_Project.entities.ValidToken;


import java.util.Optional;

@Repository
public interface ValidTokensRepository extends JpaRepository<ValidToken, Long> {

    Optional<ValidToken> existsValidTokenByToken(String token);

    ValidToken getValidTokenByToken(String token);
}
