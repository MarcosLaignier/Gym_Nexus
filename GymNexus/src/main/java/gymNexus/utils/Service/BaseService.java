package gymNexus.utils.Service;

import gymNexus.utils.Repository.BaseCrudRepository;

public interface BaseService <T,ID>{
    BaseCrudRepository getRepository();
}
