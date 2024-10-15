package gymNexus.repository;

import gymNexus.model.Matricula;
import gymNexus.utils.Repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends BaseCrudRepository<Matricula, Integer> {

}
