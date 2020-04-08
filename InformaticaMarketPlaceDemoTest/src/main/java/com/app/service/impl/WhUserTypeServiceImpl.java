package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
	private IWhUserTypeDao dao;

	@Override
	@Transactional
	public Integer saveWhUser(WhUserType userType) {
		
		return dao.saveWhUser(userType);
	}

	@Override
	@Transactional
	public void updateWhUser(WhUserType userType) {
		dao.updateWhUser(userType);

	}

	@Override
	@Transactional
	public void deleteWhUser(Integer userId) {
		dao.deleteWhUser(userId);

	}

	@Override
	@Transactional(readOnly=false)
	public WhUserType getOneWhUser(Integer userId) {
		return dao.getOneWhUser(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUsers() {
		return dao.getAllWhUsers();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getWhUserTypeByType(String userType) {
		return dao.getWhUserTypeByType(userType);
	}

}
