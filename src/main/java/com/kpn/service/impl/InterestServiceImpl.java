package com.kpn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpn.dao.InterestDao;
import com.kpn.mapper.InterestMapper;
import com.kpn.service.InterestService;


@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestMapper interestMapper;
	
	@Autowired
	private InterestDao interestDao;
	
	@Override
	public com.kpn.dao.model.Interest save(com.kpn.dto.Interest interest)
	{
		return interestDao.save(interestMapper.mapExternalToInternal(interest));
	}
}
