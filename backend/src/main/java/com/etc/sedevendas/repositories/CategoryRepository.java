package com.etc.sedevendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etc.sedevendas.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
