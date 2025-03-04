use loja2024;

create table clientes(
id_cliente int not null auto_increment primary key,
nome varchar(256) not null,
email varchar(256), 
telefone varchar(256) not null
);

create table produtos(
id_produto int not null auto_increment primary key,
nome_produto varchar(256) not null,
preco decimal
);

create table vendas(
id_venda int not null auto_increment,
id_cliente int not null, id_produto int not null,
data_venda date not null, 
quantidade int not null, 
primary key (id_venda),
foreign key (id_cliente) references clientes(id_cliente),
foreign key (id_produto) references produtos(id_produto)
);

insert into clientes (nome, email, telefone)
values ("Pedro Gabriel", "pedroxavierjardim@gmail.com", "48984044033");
insert into clientes (nome, email, telefone)
values ("Emily Bernardo", "emilybernardodias@gmail.com", "2398749272");
insert into clientes (nome, email, telefone)
values ("Bryan Bernardo", "bryanbernardodias@gmail.com", "09482374394");

insert into produtos (nome_produto, preco)
values ("Queijo", "12");
insert into produtos (nome_produto, preco)
values ("Presunto", "9");
insert into produtos (nome_produto, preco)
values ("Coxa de Frango", "7");

insert into vendas (id_cliente, id_produto, data_venda, quantidade)
values ("1", "3", "2024/11/22", 2);
insert into vendas (id_cliente, id_produto, data_venda, quantidade)
values ("1", "1", "2024/11/22", 3);
insert into vendas (id_cliente, id_produto, data_venda, quantidade)
values ("1", "2", "2024/11/22", 1);
insert into vendas (id_cliente, id_produto, data_venda, quantidade)
values ("2", "3", "2024/11/22", 2);

select * from clientes;

select clientes.nome as Nome_Cliente, produtos.nome_produto as Nome_Produto, 
vendas.quantidade as Quantidade, vendas.data_venda 
from vendas join clientes on vendas.id_cliente = clientes.id_cliente
join produtos on vendas.id_produto = produtos.id_produto;

select produtos.nome_produto from produtos
join vendas on vendas.id_produto = produtos.id_produto
where (vendas.quantidade) in (
select max(vendas.quantidade)
from vendas group by produtos.nome_produto);

SELECT clientes.nome AS Nome_Cliente, SUM(vendas.quantidade) AS Total_Vendas
FROM vendas
JOIN clientes ON vendas.id_cliente = clientes.id_cliente
GROUP BY clientes.id_cliente;

SELECT produtos.nome_produto as Produto, SUM(vendas.quantidade) AS Total_Vendas
FROM vendas
JOIN produtos ON vendas.id_produto = produtos.id_produto
GROUP BY produtos.id_produto