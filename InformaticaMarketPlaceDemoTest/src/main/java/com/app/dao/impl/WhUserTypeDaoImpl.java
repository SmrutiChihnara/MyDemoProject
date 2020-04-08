package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUser(WhUserType userType) {
		return (Integer) ht.save(userType);
	}

	@Override
	public void updateWhUser(WhUserType userType) {
		ht.update(userType);
	}

	@Override
	public void deleteWhUser(Integer userId) {
		WhUserType userType=new WhUserType();
		userType.setUserId(userId);
		ht.delete(userType);

	}

	@Override
	public WhUserType getOneWhUser(Integer userId) {
		
		return ht.get(WhUserType.class,userId);
	}

	@Override
	public List<WhUserType> getAllWhUsers() {
		
		return ht.loadAll(WhUserType.class);
	}
	
	@Override
	public List<WhUserType> getWhUserTypeByType(String userType) {
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("userType",userType)));
		return list;
	}

}
