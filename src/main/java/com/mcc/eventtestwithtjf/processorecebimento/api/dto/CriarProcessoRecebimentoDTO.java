package com.mcc.eventtestwithtjf.processorecebimento.api.dto;

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
public final class CriarProcessoRecebimentoDTO {
	private final String descricao;
	private final List<CriarProcessoRecebimentoDocumentoDTO> documentos;

	@Getter
	@Builder
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
	public static class CriarProcessoRecebimentoDocumentoDTO {
		private final String id;
	}

}
