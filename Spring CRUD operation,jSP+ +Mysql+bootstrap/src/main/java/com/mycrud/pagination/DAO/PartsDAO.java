package com.mycrud.pagination.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.mycrud.pagination.model.Parts;


//Spring JdbcTemplate can be more easily used with exotic database schemas and a stored procedure focus. Using JPA you need to make sure
//that database schema maps correctly to the domain model.
//service class and its dependency works as a model level//
@Service
public class PartsDAO {
	
	
	
	private static final String Calender = null;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource( DataSource datasource ) 
	{
		
		
		jdbcTemplate= new JdbcTemplate(  datasource);
		
		
	}
	public void save(Parts parts) {
		
		String sql="insert into parts( PRODUCT_NAME ,PRODUCR_DESCIPTION, DATE_ENTERED ,EMAIL_MANUFACTURER ,COUNTRY_MANUFACTUR ,SUBJECTS) values ('"+parts.getPRODUCT_NAME()+"', '"+parts.getPRODUCR_DESCIPTION()+"','"+ConvertDate(parts.getDATE_ENTERED())+"','"+parts.getEmail()+"','"+parts.getCOUNTRY_MANUFACTUR()+"','"+parts.getSUBJECTS()+"') "; 
				
		jdbcTemplate.update(sql);
	}
	
	public String  ConvertDate(Date date) 
	{
		
		String stringDate1="";
		
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			
			 stringDate1= dateFormat.format(date);
			
			
			
		}
		catch(Exception e){
			
			
		}
	
		return stringDate1;
		
		
		
	}
	public List<Parts> getAllParts()
	{
		return jdbcTemplate.query("Select * from parts  ", new ResultSetExtractor<List<Parts>>() {
			
			public List<Parts> extractData(ResultSet rs ) throws SQLException,DataAccessException{
				
				List<Parts> list= new ArrayList<Parts>();
				while(rs.next()){
					Parts pts =new Parts();
					
					pts.setID(rs.getInt(1));
					
					pts.setPRODUCT_NAME(rs.getString(2));
					pts.setPRODUCR_DESCIPTION(rs.getString(3));
					
					pts.setDATE_ENTERED(rs.getDate(4));
					pts.setEmail(rs.getString(5));
					pts.setCOUNTRY_MANUFACTUR(rs.getString(6));
					pts.setSUBJECTS(rs.getString(7));
					list.add(pts);
					
				}
				return list;
				
			}
			
			
		}); 
		
		
		
	}
	public Parts  getpartsbyID(int ID) {
		
		
        return jdbcTemplate.query(" Select * from parts where ID="+ID, new ResultSetExtractor<Parts>() {
			
			public Parts extractData(ResultSet rs ) throws SQLException,DataAccessException{
				
				Parts pts =new Parts();
				while(rs.next()){
					
					
					pts.setID(rs.getInt(1));
					
					pts.setPRODUCT_NAME(rs.getString(2));
					pts.setPRODUCR_DESCIPTION(rs.getString(3));
					
					pts.setDATE_ENTERED(rs.getDate(4));
					pts.setEmail(rs.getString(5));
					
					pts.setCOUNTRY_MANUFACTUR(rs.getString(6));
					pts.setSUBJECTS(rs.getString(7));
					
					
				}
				return pts;
				
			}
			
			
		}); 
		
		
		
		
	}
	public void Update(Parts pts,int ID) {
		
		
		String sqlquery= "UPDATE parts SET PRODUCT_NAME='"+pts.getPRODUCT_NAME()+"',PRODUCR_DESCIPTION='"+pts.getPRODUCR_DESCIPTION()+"',DATE_ENTERED ='"+ConvertDate(pts.getDATE_ENTERED())+"',EMAIL_MANUFACTURER='"+pts.getEmail()+"',COUNTRY_MANUFACTUR='"+pts.getCOUNTRY_MANUFACTUR()+"',SUBJECTS='"+pts.getSUBJECTS()+"' where ID="+ID+"";
		jdbcTemplate.update(sqlquery);
	}
	public void delete(int  ID) {
		String deletequery= " Delete from parts where ID="+ID+"";
		jdbcTemplate.update(deletequery);
	}
	public void deleteAll() 
	{
		String deleteallquery="DELETE FROM parts";
		jdbcTemplate.update(deleteallquery);
	}
	public int count() {
		String countquery="Select count(*) from parts";
		int count=jdbcTemplate.queryForObject(countquery, Integer.class);
		return count;
	}
	
	

}
