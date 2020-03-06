package com.mcc.eventtestwithtjf.processorecebimento.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ProcessoRecebimentoCriadoEvent implements DomainEvent {
	private final String id;
	private final String descricao;
	private final List<ProcessoRecebimentoDocumentoCriadoEvent> documentos;

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder
	public static class ProcessoRecebimentoDocumentoCriadoEvent {
		private final String id;
	}

	public static ProcessoRecebimentoCriadoEvent from(ProcessoRecebimento processoRecebimento) {
		return ProcessoRecebimentoCriadoEvent.builder()
		                                     .id(processoRecebimento.getId().toString())
		                                     .descricao(processoRecebimento.getDescricao())
		                                     .documentos(processoRecebimento.getDocumentos()
		                                                                    .stream()
		                                                                    .map(documento -> ProcessoRecebimentoDocumentoCriadoEvent.builder()
		                                                                                                                             .id(documento.getId()
		                                                                                                                                          .toString())
		                                                                                                                             .build())
		                                                                    .collect(toList()))
		                                     .build();
	}
}