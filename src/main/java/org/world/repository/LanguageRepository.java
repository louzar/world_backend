package org.world.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.world.model.Language;

@RepositoryRestResource(collectionResourceRel = "language", path = "language")
public interface LanguageRepository extends PagingAndSortingRepository<Language, Integer> {
	

}
