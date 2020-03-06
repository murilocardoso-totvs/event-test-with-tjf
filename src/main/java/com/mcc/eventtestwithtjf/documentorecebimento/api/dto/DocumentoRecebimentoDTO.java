package com.mcc.eventtestwithtjf.documentorecebimento.api.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class DocumentoRecebimentoDTO {
	private final String identificador;
	private final List<DocumentoRecebimentoItemDTO> itens;

	@Getter
	@Builder
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
	public static class DocumentoRecebimentoItemDTO {
		private final String produtoId;
		private final BigDecimal quantidade;
	}

}
