package com.employ.Empdetail.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employ.Empdetail.domain.Empdetail;
import com.employ.Empdetail.repository.EmpdetailRepository;

@Service
public class EmpdetailService {

	@Autowired
	private EmpdetailRepository repo;
	
	public List<Empdetail> listAll() {
		return repo.findAll();
	}
	
	public void save(Empdetail empdetail) {
		repo.save(empdetail);
	}
	
	public Empdetail get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}
