package com.kpn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpn.dao.ActorDao;
import com.kpn.mapper.ActorMapper;
import com.kpn.service.ActorService;


@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorMapper actorMapper;

	@Autowired
	private ActorDao actorDao;

	@Override
	public com.kpn.dao.model.Actor save(com.kpn.dto.Actor actor) {
		return actorDao.save(actorMapper.mapExternalToInternal(actor));
	}
}
