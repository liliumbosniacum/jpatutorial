package com.lilium.jpatutorial.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2022-12-18T10:58:54.961+0100")
@StaticMetamodel(Address.class)
public abstract class Address_ extends com.lilium.jpatutorial.entity.NamedEntity_ {

	public static volatile ListAttribute<Address, Person> persons;

	public static final String PERSONS = "persons";

}

