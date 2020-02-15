package pl.pw.edu.DB_App_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.DB_App_Project.entities.Rent;
import pl.pw.edu.DB_App_Project.repositories.RentRepository;

import java.util.List;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    public long addRent(Long fk_book_id, Long fk_reader_id, String rent_date, String return_date) {
        return rentRepository.save(new Rent(0L, fk_book_id, fk_reader_id, rent_date, return_date)).getId();
    }

    public long deleteRent(Long id) {
        Rent rentToDelete = rentRepository.findById(id).get();
        rentRepository.delete(rentToDelete);
        return 0L;
    }

    public Rent getOne(Long id) {
        return rentRepository.getOne(id);
    }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public long updateReturnDate(Long id, String newDate) {
        Rent rent = rentRepository.getOne(id);
        rent.setReturn_date(newDate);
        return rentRepository.save(rent).getId();
    }
}
