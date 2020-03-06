package com.mcc.eventtestwithtjf.conferencia.application.cmd;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimento;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class CriarConferenciaCmd implements DomainEvent {
	private final String identificador;
	private final List<CriarConferenciaItemCmd> itens;

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder
	public static class CriarConferenciaItemCmd {
		private final String produtoId;
		private final BigDecimal quantidade;
	}

	public static CriarConferenciaCmd from(DocumentoRecebimento documentoRecebimento) {
		return CriarConferenciaCmd.builder()
		                          .identificador(documentoRecebimento.getIdentificador())
		                          .itens(documentoRecebimento.getItens()
		                                                     .stream()
		                                                     .map(item -> CriarConferenciaItemCmd.builder()
		                                                                                         .produtoId(item.getProdutoId()
		                                                                                                        .toString())
		                                                                                         .quantidade(item.getQuantidade())
		                                                                                         .build())
		                                                     .collect(Collectors.toList()))
		                          .build();
	}
}
