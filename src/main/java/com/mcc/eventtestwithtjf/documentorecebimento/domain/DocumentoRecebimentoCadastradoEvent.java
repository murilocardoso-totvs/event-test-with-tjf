package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;

import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class DocumentoRecebimentoCadastradoEvent implements DomainEvent {
	private final String id;
	private final String identificador;
	private final List<DocumentoRecebimentoItemCadastradoEvent> itens;

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder
	public static class DocumentoRecebimentoItemCadastradoEvent {
		private final String id;
		private final String produtoId;
		private final BigDecimal quantidade;
	}

	public static DocumentoRecebimentoCadastradoEvent from(DocumentoRecebimento documentoRecebimento) {
		return DocumentoRecebimentoCadastradoEvent.builder()
		                                          .id(documentoRecebimento.getId().toString())
		                                          .identificador(documentoRecebimento.getIdentificador())
		                                          .itens(documentoRecebimento.getItens()
		                                                                     .stream()
		                                                                     .map(item -> DocumentoRecebimentoItemCadastradoEvent.builder()
		                                                                                                                         .id(item.getId()
		                                                                                                                                 .toString())
		                                                                                                                         .produtoId(item.getProdutoId()
		                                                                                                                                        .toString())
		                                                                                                                         .quantidade(item.getQuantidade())
		                                                                                                                         .build())
		                                                                     .collect(toList()))
		                                          .build();
	}
}
