package jpanative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Component
class Tester {
    final EntityManager entityManager;
    final PersonRepo personRepo;
    Tester(EntityManager entityManager, PersonRepo personRepo) {
        this.entityManager = entityManager;
        this.personRepo = personRepo;
    }

    @EventListener
    public void ctxRefreshed(ContextRefreshedEvent e) {
        System.out.println("Record exists " + personRepo.existsById(1L)); //this works

        //none of the following works
        personRepo.getReferenceById(1L);
        entityManager.find(Person.class, 1L);
        entityManager.getReference(Person.class, 1L);
    }
}

interface PersonRepo extends JpaRepository<Person, Long>{}
@Entity
class Person {
    @Id
    Long id;
    String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}