package com.mcc.eventtestwithtjf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventTestWithTjfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventTestWithTjfApplication.class, args);
	}

}

/* Para testar bastar executar o post abaixo.
 * Será disparado o evento ProcessoRecebimentoCriado que é ouvido por 
 * DocumentoRecebimentoApplicationService e ConferenciaApplicationService.
 * Após sucesso na execução de todos os listeners uma mensagem é disparada no
 * exchange my-wms.
 * 
 * endpoint (post): localhost:7170/api/v1/processosRecebimento
 * body: 
 * {
 *   "descricao": "PROCESSO 01",
 *   "documentos": [
 * 	  {
 * 	    "id": "ca713874-5bd3-4dc6-9120-f0b212d15ed5"
 *	  }
 *   ]
 * }
 */


