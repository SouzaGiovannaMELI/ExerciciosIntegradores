use movies_db;

select title, name from series inner join genres where genre_id = genres.id;

select title, first_name, last_name from episodes inner join actors where actors.id in 
	(select actor_id from actor_episode where episode_id = episodes.id);
    
select series.title, count(seasons.title) from series inner join seasons where serie_id in 
	(select serie_id from seasons where serie_id = seasons.id) group by series.title;
    
select first_name, last_name from actors where actors.id in (select actor_id from actor_movie where actors.id = actor_id and movie_id in 
	(select movies.id from movies where title like "%Star Wars%"));