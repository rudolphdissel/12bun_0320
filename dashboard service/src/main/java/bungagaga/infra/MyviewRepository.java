package bungagaga.infra;

import bungagaga.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "myviews", path = "myviews")
public interface MyviewRepository
    extends PagingAndSortingRepository<Myview, Long> {}
