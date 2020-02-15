package pl.pw.edu.DB_App_Project.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.DB_App_Project.dto.AddBookRequest;
import pl.pw.edu.DB_App_Project.dto.AddReaderRequest;
import pl.pw.edu.DB_App_Project.entities.Reader;
import pl.pw.edu.DB_App_Project.services.ReaderService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public ResponseEntity<?> getReaders() {
        List<Reader> response = readerService.getAllReaders();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReader(@PathVariable Long id) {
        Reader reader = readerService.getOne(id);
        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addReader(@RequestBody @Valid AddReaderRequest request) {
        readerService.addReader(request.getName(), request.getSurname(), request.getPesel(), request.getEmail(), request.getTel_number());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
