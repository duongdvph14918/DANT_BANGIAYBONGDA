package com.men.service;

import java.util.List;

import com.watch.entity.ViMoney;

public interface ViMoneyService {

	List<ViMoney> findAll();

	<S extends ViMoney> S save(S entity);

}
