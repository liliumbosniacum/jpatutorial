package com.lilium.jpatutorial.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2022-12-18T10:58:54.961+0100")
@StaticMetamodel(Person.class)
public abstract class Person_ extends com.lilium.jpatutorial.entity.NamedEntity_ {

	public static volatile SingularAttribute<Person, String> phoneNumber;
	public static volatile SingularAttribute<Person, Address> address;

	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String ADDRESS = "address";

}

