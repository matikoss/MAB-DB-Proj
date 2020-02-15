package pl.pw.edu.DB_App_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.Author;
import pl.pw.edu.DB_App_Project.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public long addAuthor(String name, String surname) {
        return authorRepository.save(new Author(0L, name, surname)).getId();
    }

    public long deleteAuthor(Long id) {
        Author authorToDelete = authorRepository.findById(id).get();
        authorRepository.delete(authorToDelete);
        return 0L;
    }

    public Author getOne(Long id) {
        return authorRepository.getOne(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
