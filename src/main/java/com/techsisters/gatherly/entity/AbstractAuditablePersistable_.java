package com.techsisters.gatherly.entity;

import java.util.Date;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AbstractAuditablePersistable.class)
public class AbstractAuditablePersistable_ {

	public static volatile SingularAttribute<AbstractAuditablePersistable, Date> createdDate;
	public static volatile SingularAttribute<AbstractAuditablePersistable, String> createdBy;
	public static volatile SingularAttribute<AbstractAuditablePersistable, Date> modifiedDate;
	public static volatile SingularAttribute<AbstractAuditablePersistable, String> modifiedBy;

}
