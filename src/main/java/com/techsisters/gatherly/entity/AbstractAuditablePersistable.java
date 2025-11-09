package com.techsisters.gatherly.entity;

import java.util.Date;

import com.techsisters.gatherly.util.UserUtil;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractAuditablePersistable extends AbstractPersistable {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", updatable = false)
	private Date createdDate;

	@Column(name = "created_by", updatable = false)
	@Size(max = 80) // depends on username size
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "modified_by")
	@Size(max = 80) // depends on username size
	private String modifiedBy;

	@PrePersist
	public void onPrePersist() {
		createdDate = new Date();
		modifiedDate = new Date();
		createdBy = UserUtil.getLoginUsername();
		modifiedBy = UserUtil.getLoginUsername();
	}

	@PreUpdate
	public void onPreUpdate() {
		modifiedDate = new Date();
		modifiedBy = UserUtil.getLoginUsername();
	}

}
