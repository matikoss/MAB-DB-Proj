package pl.pw.edu.DB_App_Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.DB_App_Project.entities.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader findByPesel(Long pesel);
}
