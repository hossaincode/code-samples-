package com.springbootCRUD.springbootrestapi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootCRUD.springbootrestapi.model.Record;
import com.springbootCRUD.springbootrestapi.repository.RecordRepository;



/*we use DAO as a service class between data source and our internal class like that of service in angular service difference is it can have a void return type method    */
@Service 
public class RecordDAO {
	
	
	@Autowired
	RecordRepository recordRepository;   
	
	public Record save(Record rcd) {
		
		
		 return recordRepository.save(rcd);
		
	}
	public List<Record> RetrieveAll(){
		
		return recordRepository.findAll();
	}
	public Record FindSingleRecord(Long id) {
		
		return recordRepository.findById(id).get();
	}
	
	public void DeleteSingleRecord(Record rcd ){
		
		 recordRepository.delete(rcd);
	}

}
