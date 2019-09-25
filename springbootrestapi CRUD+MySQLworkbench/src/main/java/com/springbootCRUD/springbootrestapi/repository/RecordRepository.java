package com.springbootCRUD.springbootrestapi.repository;

import com.springbootCRUD.springbootrestapi.model.Record;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RecordRepository extends  JpaRepository<Record, Long> {
	

}
