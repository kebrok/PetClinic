package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

}
