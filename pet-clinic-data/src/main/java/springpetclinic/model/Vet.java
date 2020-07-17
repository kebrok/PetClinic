package springpetclinic.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

}
