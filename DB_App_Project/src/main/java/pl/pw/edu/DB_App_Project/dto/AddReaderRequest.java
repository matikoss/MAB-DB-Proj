package pl.pw.edu.DB_App_Project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddReaderRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Long pesel;

    @NotNull
    private String email;

    @NotNull
    private Long tel_number;
}
