package pl.pw.edu.DB_App_Project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddBookRequest {

    @NotNull
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    private Long fk_author_id;

    @NotNull
    private String description;

    @NotNull
    private Long pub_year;

    @NotNull
    private String category;

    @NotNull
    private String publisher;
}
