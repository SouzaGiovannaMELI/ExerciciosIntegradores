use movies_db;

# Mostrar todos os registros da tabela de filmes
select * from movies;

# Mostrar o nome, sobrenome e classificação de todos os atores
select first_name, last_name, rating from actors;

# Mostrar o titulo de todas as séries e use alias para que tanto o nome da tabela quando o campo estejam 
# em Português.
select title as titulo from series as serie;

# Mostrar o nome e sobrenome dos atores cuja classificação é superior a 7.5
select first_name, last_name, rating from actors where rating > 7.5;

# Mostrar o título dos filmes, a classificação e os prêmios dos filmes com classificação superior a 7.5 
# e com mais de dois prêmios
select title, rating, awards from movies where rating > 7.5 and awards > 2;

# Mostrar o título dos filmes e a classificação ordenados por classificação em ordem crescente.
select title, rating from movies order by rating asc;

# Mostrar o título dos filmes e a classificação ordenados por classificação em ordem decrescente.
select title, rating from movies order by rating desc;

# Mostrar os titulos dos três primeiros filmes no banco de dados
select title from movies limit 3;

# Mostrar os titulos dos três filmes com maior classificação no banco de dados
select title from movies order by rating desc limit 3;

# Coloca os caracteres do campo indicado em maiusculo
select upper(title), rating from movies order by rating desc limit 3;

# Coloca os caracteres do campo indicado em minusculo
select lower(title), rating from movies order by rating desc limit 3;

# Mostrar o titulo e a classificação de todos os filmes cujo título é Toy Story
select title, rating from movies where title like "%toy story%";

# Mostrar o titulo e a classificação de todos os filmes cujo contenham no titulo as palavra Toy e Story, 
# independentemente da ordem em que foram escritas
select title, rating from movies where title like "%toy%story%";

# Mostras todos os atores cujos nomes começam com Sam
select first_name, last_name from actors where first_name like "Sam%";

# Mostrar o título dos filmes que saíram entre 2004 e 2008
select title from movies where year(release_date) >= 2004 and year(release_date) <= 2008;
select title from movies where year(release_date) between 2004 and 2008;

# Mostrar o título dos filmes com classificação superior a 3, com mais de 1 prêmio e com data de lançamento entre
# 1988 e 2009. Ordenar os resultados por classificação
select title, rating, awards from movies where rating > 3 and year(release_date) between 1988 and 2009 order by rating;

# insere um novo registro no BD na tabela de actors
insert into actors (first_name, last_name, rating, favorite_movie_id) values ("Tom", "Holland", 10.0, 1);

# Atualiza o ator número 51 para o nome Mauri
update actors set first_name = "Mauri" where id = 51;

# Apaga o registro com id 51
delete from actors where id = 51;

# Quantas séries temos cadastradas?
select count(*) as series from series;

# Qual a média de classificações dos actors
select avg(rating) as media from actors;

# Arredondando a média das classificações dos actors
select round(avg(rating), 2) as media from actors;

# Qual a quantidade de episódios que cada ator atuou
select actor_id, count(*) as participacoes from actor_episode group by actor_id;

# Quem atuou em pelo menos em 10 episódios
select actor_id, count(*) as participacoes from actor_episode group by actor_id having count(*) >= 10;
select actor_id, count(*) as participacoes from actor_episode group by actor_id having participacoes >= 10;