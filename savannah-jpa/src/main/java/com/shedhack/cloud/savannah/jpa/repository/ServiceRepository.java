package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.jpa.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends PagingAndSortingRepository<ServiceEntity, String> {

    @Query("from ServiceEntity s where s.organisation.id = :id")
    List<ServiceEntity> findByOrganisationId(@Param("id") String id);

}
