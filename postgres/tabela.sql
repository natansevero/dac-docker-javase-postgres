create table produto(
	id serial,
	nome text,
	preco double precision,
	tipo text,
	primary key(id)
);
insert into produto (nome, preco, tipo) values ('arroz', 2.50, 'alimento');
insert into produto (nome, preco, tipo) values ('pedra sanitaria', 3.00, 'limpeza');