CREATE TABLE tbl_produto
(
    id varchar(36),
    data jsonb,
    CONSTRAINT tbl_produto_pkey PRIMARY KEY (id)
);

CREATE TABLE tbl_documento_recebimento
(
    id varchar(36),
    data jsonb,
    CONSTRAINT tbl_documento_recebimento_pkey PRIMARY KEY (id)
);

CREATE TABLE tbl_processo_recebimento
(
    id varchar(36),
    data jsonb,
    CONSTRAINT tbl_processo_recebimento_pkey PRIMARY KEY (id)
);
insert into tbl_produto values (
'6410e9bc-155c-434d-b49b-0788ae4ae409',
'{
    "id": {
        "id": "6410e9bc-155c-434d-b49b-0788ae4ae409",
        "@class": "com.mcc.eventtestwithtjf.produto.domain.ProdutoId"
    },
    "@class": "com.mcc.eventtestwithtjf.produto.domain.Produto"
}');
insert into tbl_produto values (
'969bc39a-be8a-4396-aeaf-12724e7f8479',
'{
    "id": {
        "id": "969bc39a-be8a-4396-aeaf-12724e7f8479",
        "@class": "com.mcc.eventtestwithtjf.produto.domain.ProdutoId"
    },
    "nome": "LAPIS ABC",
    "@class": "com.mcc.eventtestwithtjf.produto.domain.Produto"
}');
insert into tbl_documento_recebimento values (
'ca713874-5bd3-4dc6-9120-f0b212d15ed5',
'{
    "id": {
        "id": "ca713874-5bd3-4dc6-9120-f0b212d15ed5",
        "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId"
    },
    "itens": [
        {
            "id": {
                "id": "f0ad8559-5333-4627-8fe6-90c84e6adb4f",
                "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItemId"
            },
            "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItem",
            "produtoId": {
                "id": "6410e9bc-155c-434d-b49b-0788ae4ae409",
                "@class": "com.mcc.eventtestwithtjf.produto.domain.ProdutoId"
            },
            "quantidade": 10
        },
        {
            "id": {
                "id": "62608d5e-8854-445e-9365-7571157e79ef",
                "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItemId"
            },
            "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItem",
            "produtoId": {
                "id": "969bc39a-be8a-4396-aeaf-12724e7f8479",
                "@class": "com.mcc.eventtestwithtjf.produto.domain.ProdutoId"
            },
            "quantidade": 5
        }
    ],
    "@class": "com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimento",
    "identificador": "NF 456/2",
    "situacaoAtual": "DISPONIVEL"
}');
