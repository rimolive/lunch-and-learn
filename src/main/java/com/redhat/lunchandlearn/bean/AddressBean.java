package com.redhat.lunchandlearn.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.forge.persistence.PersistenceUtil;

import com.redhat.lunchandlearn.entity.Address;

@Named("addressBean")
@Stateful
@ConversationScoped
public class AddressBean extends PersistenceUtil {
	
	private List<Address> list = null;
	
	private Address address;
	
	@Inject
	private Conversation conversation;
	
	public List<Address> getList() {
		list = findAll(Address.class);
		return list;
	}

	public void setList(List<Address> list) {
		this.list = list;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String load(Integer id) {
		conversation.begin();
		Long longId = new Long(id + "");
		address = findById(Address.class, longId);
		return "load";
	}
	
	public String prepareCreate() {
		conversation.begin();
		if(address == null) {
			address = new Address();
		}
		return "prepare";
	}
	
	public String create() {
		getEntityManager().joinTransaction();
		getEntityManager().persist(address);
		conversation.end();
		return "create";
	}
	
	public String merge() {
		getEntityManager().joinTransaction();
		getEntityManager().merge(address);
		conversation.end();
		return "merge";
	}
	
	public String remove(Integer id) {
		Long longId = new Long(id + "");
		getEntityManager().joinTransaction();
		getEntityManager().remove(findById(Address.class, longId));
		return "remove";
	}

}
