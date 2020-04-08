package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Component
public class WhUserTypeConverter implements Converter<Object,WhUserType> {
	@Autowired
	private IWhUserTypeService service;

	@Override
	public WhUserType convert(Object source) {
		try {
			String s=(String) source;
			int userId=Integer.parseInt(s);
			WhUserType user=service.getOneWhUser(userId);
			return user;
		}catch(Exception e) {
			return new WhUserType();
		}
	}
}
