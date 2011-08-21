package com.redhat.lunchandlearn.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class Employee implements java.io.Serializable {
	
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id", updatable = false, nullable = false)
	Long id = null;
	
	@Version
	private @Column(name = "version")
	int version = 0;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@NotNull
	@Column
	private Integer number;

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	@NotNull
	@Column
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
