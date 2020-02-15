package pl.pw.edu.DB_App_Project.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddRentRequest {

    @NotNull
    private Long fk_book_id;

    @NotNull
    private Long fk_reader_id;

    @NotNull
    private String rent_date;

    @NotNull
    private String return_date;
}
