package gymNexus.repository;

import gymNexus.model.Pessoa;
import gymNexus.utils.Repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BaseCrudRepository<Pessoa, Integer> {

}
