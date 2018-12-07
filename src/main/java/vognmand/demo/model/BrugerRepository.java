package vognmand.demo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrugerRepository extends CrudRepository<Bruger,Long> {
    Bruger findById(long id);
}
