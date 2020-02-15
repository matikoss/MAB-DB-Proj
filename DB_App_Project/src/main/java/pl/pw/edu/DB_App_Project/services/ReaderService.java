package pl.pw.edu.DB_App_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.Reader;
import pl.pw.edu.DB_App_Project.repositories.ReaderRepository;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public long addReader(String name, String surname, Long pesel, String email, Long tel_number) {
        return readerRepository.save(new Reader(0L, name, surname, pesel, email, tel_number)).getId();
    }

    public long deleteReaderByPesel(Long pesel) {
        Reader readerToDelete = readerRepository.findByPesel(pesel);
        readerRepository.delete(readerToDelete);
        return 0L;
    }

    public long deleteReader(Long id) {
        Reader readerToDelete = readerRepository.findById(id).get();
        readerRepository.delete(readerToDelete);
        return 0L;
    }

    public Reader getOneByPesel(Long pesel) {
        return readerRepository.findByPesel(pesel);
    }

    public Reader getOne(Long id) {
        return readerRepository.getOne(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}
