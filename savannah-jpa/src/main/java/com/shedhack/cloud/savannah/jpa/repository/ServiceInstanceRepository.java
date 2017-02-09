package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.jpa.entity.ServiceInstanceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceInstanceRepository extends PagingAndSortingRepository<ServiceInstanceEntity, String> {

    @Query("from ServiceInstanceEntity s where s.service.id = :id")
    List<ServiceInstanceEntity> findByService(@Param("id") String id);

    @Query("from ServiceInstanceEntity s where s.profile.id = :id and s.service.name = :name")
    List<ServiceInstanceEntity> findByProfile(@Param("name") String name, @Param("id") String id);
}
