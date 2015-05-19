package org.world.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.world.model.CountryLn;

@RepositoryRestResource(collectionResourceRel = "countryln", path = "countryln")
public interface CountryLnRepository extends PagingAndSortingRepository<CountryLn, Integer> {

}
