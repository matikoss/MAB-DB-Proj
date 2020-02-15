package pl.pw.edu.DB_App_Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.DB_App_Project.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String name);
}
