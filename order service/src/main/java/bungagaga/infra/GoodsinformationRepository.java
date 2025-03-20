package bungagaga.infra;

import bungagaga.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "goodsinformations",
    path = "goodsinformations"
)
public interface GoodsinformationRepository
    extends PagingAndSortingRepository<Goodsinformation, Long> {}
