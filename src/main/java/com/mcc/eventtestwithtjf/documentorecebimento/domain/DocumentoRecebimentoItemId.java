package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentoRecebimentoItemId {

	@Getter
	private UUID id;

	public static DocumentoRecebimentoItemId generate() {
		return new DocumentoRecebimentoItemId(UUID.randomUUID());
	}

	public static DocumentoRecebimentoItemId from(String id) {
		return id != null ? new DocumentoRecebimentoItemId(UUID.fromString(id)) : null;
	}

	@Override
	public String toString() {
		return id.toString();
	}
}