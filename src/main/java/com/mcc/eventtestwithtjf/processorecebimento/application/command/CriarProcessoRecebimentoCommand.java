package com.mcc.eventtestwithtjf.processorecebimento.application.command;

import java.util.List;

import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class CriarProcessoRecebimentoCommand {
	private final String descricao;
	private final List<CriarProcessoRecebimentoDocumentoCommand> documentos;
	
	@Getter
	@EqualsAndHashCode
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder
	public static class CriarProcessoRecebimentoDocumentoCommand {
		private final DocumentoRecebimentoId id;
	}
}
