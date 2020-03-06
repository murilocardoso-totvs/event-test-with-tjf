package com.mcc.eventtestwithtjf.documentorecebimento.domain;

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
public class DocumentoRecebimentoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private UUID id;

	public static DocumentoRecebimentoId generate() {
		return new DocumentoRecebimentoId(UUID.randomUUID());
	}

	public static DocumentoRecebimentoId from(String id) {
		return id != null ? new DocumentoRecebimentoId(UUID.fromString(id)) : null;
	}

	@Override
	public String toString() {
		return id.toString();
	}
}