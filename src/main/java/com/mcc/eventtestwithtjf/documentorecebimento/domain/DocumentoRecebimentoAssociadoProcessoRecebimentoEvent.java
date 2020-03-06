package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class DocumentoRecebimentoAssociadoProcessoRecebimentoEvent implements DomainEvent {
	private final String id;

	public static DocumentoRecebimentoAssociadoProcessoRecebimentoEvent from(DocumentoRecebimento documentoRecebimento) {
		return new DocumentoRecebimentoAssociadoProcessoRecebimentoEvent(documentoRecebimento.getId().toString());
	}
}
