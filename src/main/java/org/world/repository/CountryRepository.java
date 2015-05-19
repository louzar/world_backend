package org.world.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.world.model.Country;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

}
