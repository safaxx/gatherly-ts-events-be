package com.techsisters.gatherly.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPersistable implements Persistable<String> {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return this.id == null;
	}

}
