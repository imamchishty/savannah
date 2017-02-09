package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.jpa.entity.DependencyPK;
import com.shedhack.cloud.savannah.jpa.entity.OrganisationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DependencyRepository extends PagingAndSortingRepository<OrganisationEntity, DependencyPK> {

}
