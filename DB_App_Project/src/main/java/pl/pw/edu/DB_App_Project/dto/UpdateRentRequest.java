package pl.pw.edu.DB_App_Project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateRentRequest {
    @NotNull
    private String new_return_date;
}
