package com.mcc.eventtestwithtjf.conferencia.application;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.mcc.eventtestwithtjf.conferencia.application.cmd.CriarConferenciaCmd;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.mcc.eventtestwithtjf.documentorecebimento.repository.DocumentoRecebimentoRepository;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoCriadoEvent;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Service
@Transactional
public class ConferenciaRecebimentoApplicationService {
	
	private final DocumentoRecebimentoRepository documentoRecebimentoRepository;
	private final ApplicationEventPublisher publisher;
	
	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void on(ProcessoRecebimentoCriadoEvent event) {
		
		log.info("-- Begin ConferenciaRecebimentoApplicationService --");
		
		event.getDocumentos().forEach(processoRecebimentoDocumento -> {
			var documentoRecebimento = documentoRecebimentoRepository.findById(DocumentoRecebimentoId.from(processoRecebimentoDocumento.getId()))
										  							 .orElseThrow();
			
			publisher.publishEvent(CriarConferenciaCmd.from(documentoRecebimento));
		});
		
		log.info("-- End ConferenciaRecebimentoApplicationService --");
	}
}
