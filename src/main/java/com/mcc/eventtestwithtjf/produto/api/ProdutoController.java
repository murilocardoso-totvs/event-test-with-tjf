package com.mcc.eventtestwithtjf.produto.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcc.eventtestwithtjf.produto.api.dto.CadastrarProdutoDTO;
import com.mcc.eventtestwithtjf.produto.application.ProdutoApplicationService;
import com.mcc.eventtestwithtjf.produto.application.command.CadastrarProdutoCommand;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(path = ProdutoController.PATH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@ApiGuideline(ApiGuidelineVersion.v1)
@AllArgsConstructor
public class ProdutoController {
	public static final String PATH = "/api/v1/produtos";

	private final ProdutoApplicationService service;

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody CadastrarProdutoDTO dto) {

		var cmd = CadastrarProdutoCommand.builder().id(ProdutoId.generate()).nome(dto.getNome()).build();

		var id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}
}
