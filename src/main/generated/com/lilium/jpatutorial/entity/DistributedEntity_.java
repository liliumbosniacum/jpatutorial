package com.lilium.jpatutorial.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2022-12-08T23:51:29.504+0100")
@StaticMetamodel(DistributedEntity.class)
public abstract class DistributedEntity_ {

	public static volatile SingularAttribute<DistributedEntity, Long> createdTimestamp;
	public static volatile SingularAttribute<DistributedEntity, Long> modifiedTimestamp;
	public static volatile SingularAttribute<DistributedEntity, String> id;

	public static final String CREATED_TIMESTAMP = "createdTimestamp";
	public static final String MODIFIED_TIMESTAMP = "modifiedTimestamp";
	public static final String ID = "id";

}

