package fr.afcepf.ad1.springpetclinic.bootstrap;

import fr.afcepf.ad1.springpetclinic.model.*;
import fr.afcepf.ad1.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VetService vetService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, PetService petService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VetService vetService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.vetService = vetService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        System.out.println("Load specialties");

        // Add pet types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load pet types");

        // Add owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Steevie");
        owner1.setLastName("Boulet");
        owner1.setAddress("123 rue Delarue");
        owner1.setCity("Cityville");
        owner1.setTelephone("47472461");
        Pet steeviesPet = new Pet();
        steeviesPet.setPetType(savedDogPetType);
        steeviesPet.setOwner(owner1);
        steeviesPet.setName("Felix");
        steeviesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(steeviesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kenza");
        owner2.setLastName("Lolope");
        owner2.setAddress("12 boulevard Grand boulevard");
        owner2.setCity("Villecity");
        owner2.setTelephone("47472463");
        Pet kenzasPet = new Pet();
        kenzasPet.setPetType(savedCatPetType);
        kenzasPet.setOwner(owner2);
        kenzasPet.setName("Hercule");
        kenzasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(kenzasPet);
        ownerService.save(owner2);

        System.out.println("Load owner and pet");

        // Insert visit
        Visit catVisit = new Visit();
        catVisit.setDescription("Cat visit");
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(kenzasPet);
        visitService.save(catVisit);

        System.out.println("Load visit");

        // Insert vet
        Vet vet1 = new Vet();
        vet1.setFirstName("Allan");
        vet1.setLastName("Grant");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gep");
        vet2.setLastName("Eto'o");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Load vets");
    }
}
