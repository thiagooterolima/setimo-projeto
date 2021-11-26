insert categoria(nome) value ('Refrigerante');
insert categoria(nome) value ('Salgadinho');
insert categoria(nome) value ('Cereal');

insert produto(nome, preco, quantidade, validade, categoria_codigo) value ('Coca Cola', 12.00, 10, '2022-01-30', 1);
insert produto(nome, preco, quantidade, validade, categoria_codigo) value ('Fanta lata', 10.00, 5, '2022-01-30', 1);
insert produto(nome, preco, quantidade, validade, categoria_codigo) value ('Sucrilho', 10.00, 1, '2022-01-30', 3);

insert estado(nome,sigla) value('Sao Paulo','SP');
insert estado(nome,sigla) value('Rio de Janeiro','RJ');

insert cidade(nome,estado_codigo) value('Ourinhos',1);