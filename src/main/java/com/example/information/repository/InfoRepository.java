package com.example.information.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.information.entity.Info;

public interface InfoRepository extends JpaRepository<Info, Long> {

}
