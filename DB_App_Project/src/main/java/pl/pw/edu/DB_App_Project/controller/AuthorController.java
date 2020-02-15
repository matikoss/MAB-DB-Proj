package pl.pw.edu.DB_App_Project.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.DB_App_Project.dto.AddAuthorRequest;
import pl.pw.edu.DB_App_Project.entities.Author;
import pl.pw.edu.DB_App_Project.services.AuthorService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<?> getAuthors() {
        List<Author> response = authorService.getAllAuthors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthors(@PathVariable Long id) {
        Author author = authorService.getOne(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody @Valid AddAuthorRequest request) {
        authorService.addAuthor(request.getName(), request.getSurname());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
