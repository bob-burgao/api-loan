CREATE TABLE pessoa (
	id integer NOT NULL,
	nome varchar(50) NOT NULL,
	identificador varchar(50) NOT NULL,
    data_nascimento date NOT NULL,
    tipo_identificador varchar(50) NOT NULL,
    valor_min_mensal decimal(18,4) NOT NULL,
    valor_max_emprestimo decimal(18,4) NOT NULL
);
alter table pessoa add constraint pk_pessoa PRIMARY KEY (id);


CREATE TABLE emprestimo (
	id integer NOT NULL,
    id_pessoa integer NOT NULL,
	valor_emprestimo decimal(18,4) NOT NULL,
    numero_parcelas integer NOT NULL,
    status_pagamento varchar(50) NOT NULL,
    data_criacao date NOT NULL
);
alter table emprestimo add constraint fk_pessoa_emprestimo foreign key (id_pessoa)  REFERENCES pessoa (id);
alter table emprestimo add constraint pk_emprestimo PRIMARY KEY (id);