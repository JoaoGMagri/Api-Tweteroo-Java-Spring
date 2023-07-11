package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.model.Twittes;

@Repository
public interface TwitterRepository extends JpaRepository<Twittes, Long> {
    
}
