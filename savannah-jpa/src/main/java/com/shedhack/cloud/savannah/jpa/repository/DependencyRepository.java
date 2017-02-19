package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.core.model.Dependency;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.jpa.entity.DependencyEntity;
import com.shedhack.cloud.savannah.jpa.entity.DependencyPK;
import com.shedhack.cloud.savannah.jpa.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DependencyRepository extends PagingAndSortingRepository<DependencyEntity, DependencyPK> {

    @Query("from DependencyEntity e where e.primaryKey.name = :name")
    List<Dependency> findDependencyByName(@Param("name") String name);

    @Query("from DependencyEntity e where e.instance.id = :instanceIds")
    List<? extends Dependency> findDependencyByServiceInstance(@Param("instanceId") String serviceInstanceId);

    @Query("select instance from DependencyEntity e where e.primaryKey.name = :name")
    List<? extends ServiceInstance> findServiceInstancesByDependencyName(@Param("name") String name);
}
