package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUser(WhUserType userType);
	public void updateWhUser(WhUserType userType);
	public void deleteWhUser(Integer userId);
	public WhUserType getOneWhUser(Integer userId);
	public List<WhUserType> getAllWhUsers();
	public List<WhUserType> getWhUserTypeByType(String userType);

}
