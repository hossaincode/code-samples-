package com.springbootCRUD.springbootrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootCRUD.springbootrestapi.DAO.RecordDAO;
import com.springbootCRUD.springbootrestapi.model.Record;

@RestController
@RequestMapping("/Records") 
//org.springframework.web.bind.annotation.RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.


//should think about this class as a all the incoming request to this server to a handler class or method.
public class RecordController {
	
	/*// Autowired  feature of spring framework enables you to inject the
	//object dependency implicitly
	 * 
	 */
	@Autowired
	RecordDAO recordDao;
	
	/*//@PostMapping is specialized version of @RequestMapping annotation 
		//that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
		//@PostMapping annotated methods handle the HTTP POST requests matched with
		// given URI expression. e.g.
	*/	
	@PostMapping("/saveRecords")
	public Record createRecord(@Valid @RequestBody Record rcd) {
		
		
		return recordDao.save(rcd); 
		//no need to add this. injected function just use it as a variable
		
		// whenever a url is encountered with /Records/saveRecords to this server this function will be called
	    }
   /*//	@Valid isn't a Spring annotation but a JSR-303 annotation
    //	(which is the Bean Validation standard). What it does is it basically checks
    //	if the data that you send to the method is valid or not (it will validate the scriptFile for you).
	//@Valid will format the output of an incorrect REST call into formatted JSON instead
	//of a blob of barely readable text. This is very useful if you are creating a commercially 
	//consumable API for your users.
	*/
	/*Spring automatically deserializes the JSON into a Java type assuming 
	 * an appropriate one is specified. By default, the type we annotate with
	 *  the @RequestBody annotation must correspond to the JSON sent from our
	 *   client-side controller:
	 */
	@GetMapping("/getallRecords")
	public List<Record> returnALlRecords(){
		return recordDao.RetrieveAll();
	}
	/*
	 * For example, if the incoming HTTP request to retrieve a book on topic "Java" is
	 *  http://localhost:8080/shop/order/1001/receipts?date=12-05-2017, 
	 * then you can use the @RequestParam annotation to retrieve the query parameter date
	 *  and you can use @PathVariable to extract the orderId i.e. "1001" as shown below:
	 *  it also formats it to expected type for the method or class 
	 *  */
	@GetMapping("/getRecords/{id}")
	public ResponseEntity<Record> getanRecordById(@PathVariable(value="id") Long rcdid ){
		 Record rcd= recordDao.FindSingleRecord(rcdid);
		
		 
		 if(rcd==null){
			 return ResponseEntity.notFound().build();
		 }
		 else {
			 return ResponseEntity.ok().body(rcd);
		 }
		 
		
	}
	/*
	 * @RequestBody annotated parameters get linked to the HTTP request body.
	Parameter values are converted to the declared method argument type using HttpMessageConverters.
	This annotation indicates a method parameter should be bound to the body of the web request.
	*/
	
	@PutMapping("/getRecords/{id}")
	public ResponseEntity<Record> UpdateRecordById (@PathVariable (value="id") Long rcdid, @Valid @RequestBody Record rcdincoming  ){
	    Record rcd= recordDao.FindSingleRecord(rcdid);
	    if(rcd==null) {
	    	return ResponseEntity.notFound().build();
	    }
	    else {
	    	rcd.setArtist(rcdincoming.getArtist());
	    	rcd.setGenre(rcd.getGenre());
	    	rcd.setName(rcdincoming.getName());
	    	rcd.setYear(rcdincoming.getYear());
	    	 
	    	Record updatedRecord = recordDao.save(rcd);
	    	return ResponseEntity.ok().body(updatedRecord);

	    }
		
		
	}
	@DeleteMapping("/deleteRecord/{id}")
	public ResponseEntity<Record> DeleteRecord( @PathVariable(value="id") Long rcdid ) {
		Record deletthisrecord = recordDao.FindSingleRecord(rcdid);
		if(deletthisrecord==null) {
			 return ResponseEntity.notFound().build();
			
		}
		else {
			recordDao.DeleteSingleRecord(deletthisrecord);
			return ResponseEntity.ok().build();
		}
		
		
	}
	
	
	

}
