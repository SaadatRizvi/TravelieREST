package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.VanDAO;
import com.travelie.entity.Van;

@Service
public class VanServiceImpl implements VanService {

	@Autowired
	private VanDAO vanDAO;
	
	@Override
	public List<Van> getVans() {
		List<Van> vans = new ArrayList<>();
		vanDAO.findAll()
		.forEach(vans::add);
		return vans;
	}

	@Override
	public void saveVan(Van theVan) {
		vanDAO.save(theVan);

	}

	@Override
	public Van getVan(int theId) {
		
		return vanDAO.findOne(theId);
	}

	@Override
	public void deleteVan(int theId) {
		vanDAO.delete(theId);

	}

	@Override
	public List<Van> getAvailableVans() {
		
		List <Van> vans = getVans();
		
		List<Van> availableVans = new ArrayList<Van>();
		
		for (Van temp: vans){
			
			if (temp.getFlagged()==0){
				
				availableVans.add(temp);
			}
		}
		
		return availableVans;
	}


	
	
	}

