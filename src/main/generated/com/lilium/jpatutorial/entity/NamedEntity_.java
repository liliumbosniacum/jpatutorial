package com.lilium.jpatutorial.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2022-12-09T16:18:14.794+0100")
@StaticMetamodel(NamedEntity.class)
public abstract class NamedEntity_ extends com.lilium.jpatutorial.entity.DistributedEntity_ {

	public static volatile SingularAttribute<NamedEntity, String> name;

	public static final String NAME = "name";

}

