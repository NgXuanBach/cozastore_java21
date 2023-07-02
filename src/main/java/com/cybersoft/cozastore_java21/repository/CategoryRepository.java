package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

}
