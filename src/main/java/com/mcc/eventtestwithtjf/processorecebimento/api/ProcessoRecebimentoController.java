package com.mcc.eventtestwithtjf.processorecebimento.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.mcc.eventtestwithtjf.processorecebimento.api.dto.CriarProcessoRecebimentoDTO;
import com.mcc.eventtestwithtjf.processorecebimento.application.ProcessoRecebimentoApplicationService;
import com.mcc.eventtestwithtjf.processorecebimento.application.command.CriarProcessoRecebimentoCommand;
import com.mcc.eventtestwithtjf.processorecebimento.application.command.CriarProcessoRecebimentoCommand.CriarProcessoRecebimentoDocumentoCommand;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = ProcessoRecebimentoController.PATH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@ApiGuideline(ApiGuidelineVersion.v1)
@AllArgsConstructor
public class ProcessoRecebimentoController {
	public static final String PATH = "/api/v1/processosRecebimento";

	private final ProcessoRecebimentoApplicationService service;

	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody CriarProcessoRecebimentoDTO dto) {

		var cmd = CriarProcessoRecebimentoCommand.builder()
		                                         .descricao(dto.getDescricao())
		                                         .documentos(dto.getDocumentos()
		                                                        .stream()
		                                                        .map(documento -> CriarProcessoRecebimentoDocumentoCommand.builder()
		                                                                                                                  .id(DocumentoRecebimentoId.from(documento.getId()))
		                                                                                                                  .build())
		                                                        .collect(Collectors.toList()))
		                                         .build();

		var id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}
}
