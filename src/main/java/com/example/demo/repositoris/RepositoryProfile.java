package com.example.demo.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfile extends JpaRepository<EntityProfile,String> {
}

