package com.redhat.lunchandlearn.interfaces;

import java.util.List;

public interface Crudable<T,I> {
	
	List<T> getList(Class<? extends Persistable> type);
	
	String load(I id);
	
	String prepareCreate();
	
	String create();
	
	String merge();
	
	String remove(I id);

}
