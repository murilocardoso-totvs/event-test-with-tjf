package com.mcc.eventtestwithtjf.processorecebimento.domain;

import java.io.Serializable;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProcessoRecebimentoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private UUID id;

	public static ProcessoRecebimentoId generate() {
		return new ProcessoRecebimentoId(UUID.randomUUID());
	}

	public static ProcessoRecebimentoId from(String id) {
		return id != null ? new ProcessoRecebimentoId(UUID.fromString(id)) : null;
	}

	@Override
	public String toString() {
		return id.toString();
	}
}