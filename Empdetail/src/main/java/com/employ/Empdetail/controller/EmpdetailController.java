package com.employ.Empdetail.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employ.Empdetail.domain.Empdetail;
import com.employ.Empdetail.service.EmpdetailService;

@RestController
public class EmpdetailController {
	
	@Autowired
	private EmpdetailService service;
	@GetMapping("/empdetails")
	public List<Empdetail> viewData()
	{
		return service.listAll();	
	}

	@GetMapping("/empdetails/{id}")
 	public Empdetail getTask(@PathVariable int id)
	{
		return service.get(id);	
	}
	
	
	
	@PutMapping(value="/empdetails/{id}")
	public ResponseEntity<?> editEmpDEtailsPage(@RequestBody @Valid Empdetail newtask, @PathVariable int id) {
		try {
			Empdetail existingtask= service.get(id);
			existingtask.setEmpname(newtask.getEmpname());
			existingtask.setEmpmobile(newtask.getEmpmobile());
			existingtask.setEmpemail(newtask.getEmpemail());
			existingtask.setEmpaddress(newtask.getEmpaddress());
			existingtask.setEmppassword(newtask.getEmppassword());
			existingtask.setModifieddate(java.time.LocalDateTime.now());
			
			service.save(existingtask);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception exp) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/empdetails")
	public String add(@RequestBody @Valid Empdetail  empdetail ,BindingResult result)
	{
		empdetail.setCreateddate(java.time.LocalDateTime.now());
		empdetail.setModifieddate(java.time.LocalDateTime.now());
		if(result.hasErrors())
		{
			return "insert";
		}
		service.save(empdetail);
		return "redirect:/index";
		
		
	}
	
	@DeleteMapping("/empdetails/{id}")
	public void delete(@PathVariable int id)
	{
		service.delete(id);
	}
		
	
}
