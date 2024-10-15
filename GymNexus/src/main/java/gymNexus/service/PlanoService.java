package gymNexus.service;

import gymNexus.model.Plano;
import gymNexus.repository.PlanoRepository;
import gymNexus.utils.Service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PlanoService extends AbstractBaseService<Plano, Integer> {

    @Autowired
    private PlanoRepository planoRepository;

    @Override
    public PlanoRepository getRepository() {
        return planoRepository;
    }
}
