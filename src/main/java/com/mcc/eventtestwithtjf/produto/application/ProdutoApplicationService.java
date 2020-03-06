package com.mcc.eventtestwithtjf.produto.application;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.mcc.eventtestwithtjf.produto.application.command.CadastrarProdutoCommand;
import com.mcc.eventtestwithtjf.produto.domain.Produto;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoDomainRepository;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class ProdutoApplicationService {
	private final ProdutoDomainRepository repository;
	private final ApplicationEventPublisher publisher;

	public ProdutoId handle(CadastrarProdutoCommand cmd) {

		var produto = Produto.builder().id(cmd.getId()).nome(cmd.getNome()).build();

		repository.insert(produto);

		produto.getEvents().forEach(publisher::publishEvent);

		return produto.getId();
	}
}
