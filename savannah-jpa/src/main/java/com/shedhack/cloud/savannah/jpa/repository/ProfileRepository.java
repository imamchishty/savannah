package com.shedhack.cloud.savannah.jpa.repository;

import com.shedhack.cloud.savannah.jpa.entity.ProfileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, String> {

}
