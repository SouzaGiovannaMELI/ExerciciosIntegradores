select title as movie from movies where not exists (select favorite_movie_id from actors 
where favorite_movie_id = movies.id);

select count(title) from movies where exists (select favorite_movie_id from actors 
where favorite_movie_id = movies.id);

select title from movies where id not in (select favorite_movie_id from actors);

# Quantas temporadas estão cadastradas
select count(*) from seasons;

# Quantas temporadas existem para cada série
select count(*) from seasons GROUP BY serie_id;
select series.title, count(*) as temporadas from seasons inner join series on series.id = seasons.serie_id group by series.id;

# Quantas temporadas existem para a série The Walking Dead
select series.title, count(*) from seasons inner join series on series.id = seasons.serie_id where series.title = "The Walking Dead" group by serie_id;

# Quais séries tem mais de 5 temporadas
select series.title, count(*) as temporadas from seasons inner join series on series.id = seasons.serie_id group by serie_id having temporadas > 5;

# Quais as 3 séries com maior número de temporadas
select series.title, count(*) as temporadas from seasons inner join series on series.id = seasons.serie_id group by serie_id order by temporadas desc limit 3;

# Quais os nomes dos atores que trabalham em filmes com avaliação maior que 9.1
select first_name from actors inner join actor_movie on actor_id = actors.id where movie_id in (select id from movies where rating > 9.1);