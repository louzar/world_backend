package org.world.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "countryln", path = "countryln")
public interface CountryLnRepository extends PagingAndSortingRepository<CountryLn, Integer> {

}
