package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.WebdataDAO;
import com.travelie.entity.Webdata;

@Service
public class WebdataServiceImpl implements WebdataService {

	@Autowired
	private WebdataDAO webdataDAO;
	
	@Override
	public List<Webdata> getWebdatas() {
		List<Webdata> webdatas = new ArrayList<>();
		webdataDAO.findAll()
		.forEach(webdatas::add);
		return webdatas;
	}

	@Override
	public void saveWebdata(Webdata theWebdata) {
		webdataDAO.save(theWebdata);

	}

	@Override
	public Webdata getWebdata(int theId) {
		
		return webdataDAO.findOne(theId);
	}

	@Override
	public void deleteWebdata(int theId) {
		webdataDAO.delete(theId);

	}

	
	}

