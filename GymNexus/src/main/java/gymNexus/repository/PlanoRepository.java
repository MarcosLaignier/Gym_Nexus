package gymNexus.repository;

import gymNexus.model.Plano;
import gymNexus.utils.Repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanoRepository extends BaseCrudRepository<Plano, Integer> {

}
