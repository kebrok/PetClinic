package springpetclinic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialty extends BaseEntity {

    private String description;

}
