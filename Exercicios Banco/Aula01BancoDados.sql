# Criando o banco de dados
create database bd_teste;

# Indica qual banco de dados vai ser usado nesse arquivo
use bd_teste;

# Cria uma nova tabela chamada produto
create table produto (
	id integer primary key,
    nome varchar(100) not null,
    preco double
);

# Apaga a tabela produto
drop table produto;

# Insere um registro na tabela de produtos
insert into produto values (1, 'Teclado', 150);
insert into produto values (2, 'Mouse', 50);
insert into produto values (3, 'Mouse Gamer', 100);
# Essa inserção da erro pois não se pode cadastrar 2 produtos com a mesma chave primária
-- insert into produto values (1, 'Teste', 150);
# Essa inserção da erro pois não se pode cadastrar um produto com o nome null
-- insert into produto values (3, null, 50);

# Busque todos os campos de todos os registros da tabela de produtos
select * from produto;

# Busque os nomes dos produtos cadastrados
select nome from produto;

# Busque os nomes e preços dos produtos cadastrados
select nome, preco from produto;

# Busque as informações do produto com código 2
select * from produto where id = 1;

# Busque todos os preçoes de mouses
select nome, preco from produto where nome like "%Mouse%";