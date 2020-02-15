package pl.pw.edu.DB_App_Project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddAuthorRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;
}
