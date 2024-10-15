package gymNexus.service;

import gymNexus.model.Matricula;
import gymNexus.repository.MatriculaRepository;
import gymNexus.utils.Service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService extends AbstractBaseService<Matricula, Integer> {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public MatriculaRepository getRepository() {
        return matriculaRepository;
    }
}
