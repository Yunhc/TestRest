package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.TestRest.info.model.City;
import com.example.TestRest.info.model.User;
import com.example.TestRest.info.repository.CityRepository;

@Service
public class InfoService {
	
	private final CityRepository cityRepository;
	
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public User getProjectInfo() {
		
		User users = new User();
		users.id = "10001";
		users.password = "wavelink";
		users.name = "ȫ�浿";
		users.email = "hgd@wavelink.co.kr";
		
		return users;
	}
	
	public List<City> getCityList() {
		return this.cityRepository.findList();
	}
}