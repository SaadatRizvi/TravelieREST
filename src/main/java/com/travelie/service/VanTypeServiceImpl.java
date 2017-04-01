package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.VanTypeDAO;
import com.travelie.entity.VanType;

@Service
public class VanTypeServiceImpl implements VanTypeService {

	@Autowired
	private VanTypeDAO vanTypeDAO;
	
	@Override
	public List<VanType> getVanTypes() {
		List<VanType> vanTypes = new ArrayList<>();
		vanTypeDAO.findAll()
		.forEach(vanTypes::add);
		return vanTypes;
	}

	@Override
	public void saveVanType(VanType theVanType) {
		vanTypeDAO.save(theVanType);

	}

	@Override
	public VanType getVanType(int theId) {
		
		return vanTypeDAO.findOne(theId);
	}

	@Override
	public void deleteVanType(int theId) {
		vanTypeDAO.delete(theId);

	}

	
	}

