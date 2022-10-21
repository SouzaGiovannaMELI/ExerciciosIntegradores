use movies_db;

select count(*) from genres; -- 12
select count(*) from movies; -- 21

select count(*) from genres cross join movies; -- 252

select count(*) from genres inner join movies on movies.genre_id = genres.id; -- 19

# filmes sem generos cadastrados
select * from movies where genre_id is null;

insert into genres values (null, now(), null, "Novo Genero", 13, 1);

select count(movies.title) as filme, genres.name as genero from genres inner join movies on movies.genre_id = genres.id group by genres.name;

select movies.title as filme, genres.name as genero from genres right join movies on movies.genre_id = genres.id;

select movies.title as filme, genres.name as genero from genres left join movies on movies.genre_id = genres.id;

select movies.title as filme, genres.name as genero from genres left join movies on movies.genre_id = genres.id
union select movies.title as filme, genres.name as genero from genres right join movies on movies.genre_id = genre_id;

select * from movies right join genres on movies.genre_id = genres.id where movies.id is null;