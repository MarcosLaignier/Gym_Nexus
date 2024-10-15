package gymNexus.resource;

import gymNexus.model.Pessoa;
import gymNexus.model.Plano;
import gymNexus.service.PessoaService;
import gymNexus.utils.Resource.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/plano")
public class PlanoResource extends BaseResource<Plano, Integer> {

    @Autowired
    private PessoaService service;

    @Override
    public PessoaService getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> result = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}