package com.sandwiches.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sandwiches.api.entity.Sandwich;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

}
