package pl.pw.edu.DB_App_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.Book;
import pl.pw.edu.DB_App_Project.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public long addBook(String isbn, String title, Long fk_author_id, String description, Long pub_year, String category, String publisher) {
        return bookRepository.save(new Book(0L, isbn, title, fk_author_id, description, pub_year, category, publisher)).getId();
    }

    public long deleteBook(String title) {
        Book bookToDelete = bookRepository.findByTitle(title);
        bookRepository.delete(bookToDelete);
        return 0L;
    }

    public Book getOneBook(Long id) {
        return bookRepository.getOne(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
