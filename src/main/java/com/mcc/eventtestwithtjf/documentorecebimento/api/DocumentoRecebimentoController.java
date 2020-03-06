package com.mcc.eventtestwithtjf.documentorecebimento.api;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcc.eventtestwithtjf.documentorecebimento.api.dto.DocumentoRecebimentoDTO;
import com.mcc.eventtestwithtjf.documentorecebimento.application.DocumentoRecebimentoApplicationService;
import com.mcc.eventtestwithtjf.documentorecebimento.application.command.CadastrarDocumentoRecebimentoCommand;
import com.mcc.eventtestwithtjf.documentorecebimento.application.command.CadastrarDocumentoRecebimentoCommand.CadastrarDocumentoRecebimentoItemCommand;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = DocumentoRecebimentoController.PATH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@ApiGuideline(ApiGuidelineVersion.v1)
@AllArgsConstructor
public class DocumentoRecebimentoController {
	public static final String PATH = "/api/v1/documentosRecebimento";

	private final DocumentoRecebimentoApplicationService service;

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody DocumentoRecebimentoDTO dto) {

		var cmd = CadastrarDocumentoRecebimentoCommand.builder()
		                                              .identificador(dto.getIdentificador())
		                                              .itens(dto.getItens()
		                                                        .stream()
		                                                        .map(itemDTO -> CadastrarDocumentoRecebimentoItemCommand.builder()
		                                                                                                                .produtoId(ProdutoId.from(itemDTO.getProdutoId()))
		                                                                                                                .quantidade(itemDTO.getQuantidade())
		                                                                                                                .build())
		                                                        .collect(toList()))
		                                              .build();

		var id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}
}
