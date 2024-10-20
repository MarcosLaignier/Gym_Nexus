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
    public ResponseEntity<T> findById(@PathVariable ("id") Integer id) {
        T entityReturn = (T) getService().getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entityReturn);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) throws ServiceException {
        T entityReturn = (T) getService().save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityReturn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T entity){
        T entityReturn = (T) getService().update(entity);
        return ResponseEntity.status(HttpStatus.OK).body(entityReturn);
    }

    @DeleteMapping
    public ResponseEntity<T> delete(@RequestBody T entity){
        getService().delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
