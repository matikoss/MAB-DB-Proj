package pl.pw.edu.DB_App_Project.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.DB_App_Project.dto.AddReaderRequest;
import pl.pw.edu.DB_App_Project.dto.AddRentRequest;
import pl.pw.edu.DB_App_Project.dto.UpdateRentRequest;
import pl.pw.edu.DB_App_Project.entities.Book;
import pl.pw.edu.DB_App_Project.entities.Reader;
import pl.pw.edu.DB_App_Project.entities.Rent;
import pl.pw.edu.DB_App_Project.services.BookService;
import pl.pw.edu.DB_App_Project.services.ReaderService;
import pl.pw.edu.DB_App_Project.services.RentService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public ResponseEntity<?> getRents() {
        List<Rent> response = rentService.getAllRents();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRent(@PathVariable Long id) {
        Rent rent = rentService.getOne(id);
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @GetMapping("/reader/{readerId}")
    public ResponseEntity<?> getUserRents(@PathVariable Long readerId) {
        List<Rent> allRents = rentService.getAllRents();
        List<Rent> readerRents = new ArrayList<>();
        for (Rent rent : allRents) {
            if (rent.getFk_reader_id().equals(readerId)) {
                readerRents.add(rent);
            }
        }
        return new ResponseEntity<>(readerRents, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addRent(@RequestBody @Valid AddRentRequest request) {
        Book book = bookService.getOneBook(request.getFk_book_id());
        Reader reader = readerService.getOne(request.getFk_reader_id());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rentService.addRent(request.getFk_book_id(), request.getFk_reader_id(), request.getRent_date(), request.getReturn_date());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRentReturnDate(@PathVariable Long id, @RequestBody @Valid UpdateRentRequest request) {
        rentService.updateReturnDate(id, request.getNew_return_date());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRent(@PathVariable Long id) {
        rentService.deleteRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
