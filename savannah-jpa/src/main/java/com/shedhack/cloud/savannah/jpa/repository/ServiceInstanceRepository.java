package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.jpa.entity.ServiceInstanceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ServiceInstanceRepository extends PagingAndSortingRepository<ServiceInstanceEntity, String> {

    @Query("from ServiceInstanceEntity s where s.service.id = :id")
    List<ServiceInstanceEntity> findByService(@Param("id") String id);

    @Query("from ServiceInstanceEntity s where s.profile.name = :name")
    List<ServiceInstanceEntity> findByProfile(@Param("name") String name);

    @Query("from ServiceInstanceEntity s where s.profile.name = :profileName and s.service.name = :serviceName")
    List<ServiceInstanceEntity> findServiceInstancesByServiceAndProfile(@Param("serviceName") String serviceName, @Param("profileName") String profileName);

    @Query("from ServiceInstanceEntity s where s.service.name = :name and s.dateTime >= :start and s.dateTime <= :end")
    List<ServiceInstanceEntity> findServiceInstancesByServiceAndDate(@Param("name") String name, @Param("start") Date start, @Param("end") Date end);
}
