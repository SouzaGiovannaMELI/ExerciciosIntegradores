create database bd_indice;

 use bd_indice;
 
 create table user (
	id int,
    nome varchar(100)
 );
 
 insert into user values(1, 'Marcos');
 insert into user values(2, 'Fabiana');
 
 select * from user;
 # Usado na recuperação dos dados, trazendo somente os dados que são diferentes
 select distinct id from user;
 
 alter table user add constraint primary key (id);
 
 select * from user where id = 2;
 select * from user where nome = "Fabiana";
 
 alter table user add email varchar(100);
 
 update user set email = "marcos@email.com" where id = 2;
 
 alter table user add constraint unique(email);
 
 select * from user where email = "marcos@email.com";