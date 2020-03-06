package com.mcc.eventtestwithtjf.commom.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.NonNull;

public abstract class AggregateRoot {

	private final transient @Transient List<DomainEvent> domainEvents = new ArrayList<>(); //NOSONAR

	protected DomainEvent registerEvent(@NonNull DomainEvent event) {
		this.domainEvents.add(event);
		return event;
	}
	
	public Collection<DomainEvent> getEvents() {
		return Collections.unmodifiableList(domainEvents);
	}
	
	public void clearEvents() {
		this.domainEvents.clear();
	}
}