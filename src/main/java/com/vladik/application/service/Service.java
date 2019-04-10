package com.vladik.application.service;

import java.util.List;

import com.vladik.application.entity.AbstractEntity;


public interface Service<T extends AbstractEntity> {

	T read(Long id);

	List<T> read();

	void save(T entity);

	void delete(Long id);

}