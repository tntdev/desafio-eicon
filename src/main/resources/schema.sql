--DROP TABLE public.tb_produto
--truncate table public.tb_produto
CREATE TABLE public.tb_produto (
	id_produto int4 NOT NULL,
	numero_controle int4 NOT NULL,
	data_cadastro date NULL,
	nome_produto varchar(80) NULL,
	valor_produto numeric NULL,
	valor_total numeric(18,2) NULL,	
	quantidade_produto int4 NULL,
	codigo_cliente int4 NULL,
	CONSTRAINT tb_produto_numerocontrole_key UNIQUE (numero_controle),
	CONSTRAINT tb_produto_pk PRIMARY KEY (id_produto)
);

-- DROP SEQUENCE public.sq_tb_produto;

CREATE SEQUENCE public.sq_tb_produto
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;