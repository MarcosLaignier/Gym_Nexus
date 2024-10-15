package gymNexus.service;

import gymNexus.model.Pessoa;
import gymNexus.repository.PessoaRepository;
import gymNexus.utils.CollectionMetodsUtils;
import gymNexus.utils.Service.AbstractBaseService;
import gymNexus.utils.Validate.ValidateMetodsUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PessoaService extends AbstractBaseService<Pessoa, Integer> {

    @Autowired
    private PessoaRepository pessoaRepository;



    @Override
    public PessoaRepository getRepository() {
        return pessoaRepository;
    }

    @Override
    protected void validate(Pessoa entity) throws ServiceException {

        ValidateMetodsUtils.validateFieldsNonNull(entity);

        if (!CollectionMetodsUtils.validaDocumento(entity.getDocumento())){
            throw new IllegalArgumentException("Documento inválido");
        }

        if(!validaNascimento(entity.getNascimento())){
            throw new IllegalArgumentException("A data de nascimento não pode ser futura!");
        }


        super.validate(entity);
    }

    private Boolean validaNascimento(Date nascimento) {
        return nascimento.before(new Date());
    }
}
