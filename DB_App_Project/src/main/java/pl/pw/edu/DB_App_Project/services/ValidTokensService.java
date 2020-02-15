package pl.pw.edu.DB_App_Project.services;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.ValidToken;
import pl.pw.edu.DB_App_Project.repositories.ValidTokensRepository;


import java.util.Optional;

@Log
@Service
public class ValidTokensService {

    @Autowired
    ValidTokensRepository tokensRepository;

    public void addToken(String token) {
        ValidToken tokenToSave = new ValidToken(token);
        tokensRepository.save(tokenToSave);
    }

    public boolean isTokenExist(String token) {
        return tokensRepository.existsValidTokenByToken(token).isPresent();
    }

    public void deleteToken(String token) {
        log.info("Deleting token: " + token);
        tokensRepository.getValidTokenByToken(token);
        tokensRepository.delete(tokensRepository.getValidTokenByToken(token));
    }
}
