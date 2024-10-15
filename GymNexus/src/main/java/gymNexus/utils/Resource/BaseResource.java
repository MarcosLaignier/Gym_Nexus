package gymNexus.utils.Resource;

import gymNexus.utils.Service.AbstractBaseService;
import jakarta.websocket.server.PathParam;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseResource<T,ID> {

       public abstract AbstractBaseService getService();



    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathParam("id") Integer id) {
        T acrescimo = (T) getService().getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T novoAcrescimo) throws ServiceException {
        T acrescimo = (T) getService().save(novoAcrescimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(acrescimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T acrescimoAtualizado){
        T acrescimo = (T) getService().update(acrescimoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @DeleteMapping
    public ResponseEntity<T> delete(@RequestBody T entity){
        getService().delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
