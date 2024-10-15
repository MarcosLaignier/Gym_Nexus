package gymNexus.resource;

import gymNexus.model.Pessoa;
import gymNexus.service.PessoaService;
import gymNexus.utils.Resource.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/pessoa")
public class PessoaResource extends BaseResource<Pessoa, Integer> {

    @Autowired
    private PessoaService pessoaService;

    @Override
    public PessoaService getService() {
        return pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> result = pessoaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

/*    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
    }
}*/
