package com.redhat.lunchandlearn.decorator;

import java.util.List;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import org.jboss.forge.persistence.PersistenceUtil;

import com.redhat.lunchandlearn.interfaces.Crudable;
import com.redhat.lunchandlearn.interfaces.Persistable;

public class CrudServiceDecorator<P extends Persistable,I> extends PersistenceUtil implements Crudable<P,I> {
	
	private List<P> list;
	
	private Persistable entity;
	
	private long id = 0;
	
	@Inject
	private Conversation conversation;

	@Override
	public List<P> getList(Class<? extends Persistable> type) {
//		list = findAll(type);
		return list;
	}

	@Override
	public String load(I id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepareCreate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String merge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(I id) {
		// TODO Auto-generated method stub
		return null;
	}

}
