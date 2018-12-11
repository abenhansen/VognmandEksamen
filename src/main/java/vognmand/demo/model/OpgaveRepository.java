package vognmand.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface OpgaveRepository extends CrudRepository<Opgave,Long> {
    Opgave findById(long id);
}
