package pl.pw.edu.DB_App_Project.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.DB_App_Project.dto.AddBookRequest;
import pl.pw.edu.DB_App_Project.entities.Book;
import pl.pw.edu.DB_App_Project.services.BookService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBooks() {
        List<Book> response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Book book = bookService.getOneBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody @Valid AddBookRequest request) {
        bookService.addBook(request.getIsbn(), request.getTitle(), request.getFk_author_id(), request.getDescription(), request.getPub_year(), request.getCategory(), request.getPublisher());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<?> deleteBook(@PathVariable String title) {
        bookService.deleteBook(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
