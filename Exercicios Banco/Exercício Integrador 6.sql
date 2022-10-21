use movies_db;


select * from genres;
select * from movies;
select * from actors;
# 1. Adicione um filme à tabela de filmes.
insert into movies values (22, null, null, "Vingadores: Ultimato", 9.4, 7, "2019-04-25 00:00:00", 190, 4);

# 2. Adicione um gênero à tabela de gêneros.
insert into genres values (16, null, null, "Teste de Ação", 14, 1);

# 3. Associe o filme do ponto 1. com o gênero criado no ponto 2.
update movies set genre_id = 16 where id = 22;

# 4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado no ponto 1 como favorito.
update actors set favorite_movie_id = 22 where id = 50;

# 5. Crie uma tabela temporária da tabela filmes.
create temporary table movies_temp select * from movies;

# 6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
delete from movies_temp where awards < 5;

# 7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
select name from movies inner join genres where genres.id = genre_id and 
	(select count(*) from movies where genre_id = genres.id) > 1 group by genres.name;
    
# 8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
select * from actors inner join movies where movies.id = actors.favorite_movie_id and awards > 3;

# 9. Crie um índice no nome na tabela de filmes.
create index filme on movies (title);

# 10. Verifique se o índice foi criado corretamente. Sim

# 11. No banco de dados movies, haveria uma melhoria notável na criação de índices? Analise e justifique a resposta. 
# R: Só teria uma diferença notável se os dados pelos quais o indice forem criados fores comumente utilizados nas pesquisas

# 12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta
# R: Seria criado um indice na tabela de generos, pois o nome do gênero é requisitado muitas vezes durante as pesquisas, de modo que se for um indice
# garantimos assim a integridade dos dados daquela tabela e uma pesquisa mais rapida