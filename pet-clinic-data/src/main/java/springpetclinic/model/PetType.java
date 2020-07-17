package springpetclinic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity {

    private String name;

}
