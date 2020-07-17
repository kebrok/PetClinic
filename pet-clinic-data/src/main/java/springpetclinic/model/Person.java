package springpetclinic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person extends BaseEntity {

    private String FirstName;
    private String LastName;

}
