create database empresa_internet;
use empresa_internet;

create table plano (
	id int primary key auto_increment
    , velocidade int
    , preco float
    , desconto float
);

create table cliente (
	id int primary key auto_increment
    , nome varchar(50)
    , sobrenome varchar(100)
    , data_nascimento date
    , estado varchar(50)
    , cidade varchar(50)
    , fk_plano int 
    , constraint fk_plano foreign key (fk_plano) references plano (id)
);

INSERT INTO `plano` (`velocidade`,`preco`,`desconto`)
VALUES
  (34,56.44,15.81),
  (55,50.17,17.88),
  (96,203.61,12.70),
  (68,275.31,28.68),
  (63,177.73,36.49);
  
INSERT INTO `cliente` (`nome`,`sobrenome`,`data_nascimento`,`cidade`,`estado`,`fk_plano`)
VALUES
  ("Benjamin","Oneil","1945-11-5","Ramagundam","Rio Grande do Sul",1),
  ("Neve","Golden","1978-08-27","Goyang","Xīběi",4),
  ("Laurel","Owens","1973-04-03","Sungei Kadut","Guainía",1),
  ("Myles","Stevenson","1972-06-14","Neuwied","North Maluku",3),
  ("Kelly","Bush","1985-11-11","Hexham","Jeju",3),
  ("Alexander","Stuart","1945-11-5","Ramagundam","Rio Grande do Sul",1),
  ("Italo","Holland","1978-08-27","Goyang","Xīběi",4),
  ("Jannuary","Blanck","1973-04-03","Sungei Kadut","Guainía",1),
  ("Styles","Mason","1972-06-14","Neuwied","North Maluku",3),
  ("Mary","Steven","1985-11-11","Hexham","Jeju",5);
  
  select * from plano;
  
  select * from cliente;
  
  select nome from cliente;
  
  select nome, plano.id from cliente inner join plano on plano.id = fk_plano;
  
  select id, velocidade, preco from plano;
  
  select id, velocidade, preco from plano order by velocidade;
  
  select count(nome), plano.id from cliente inner join plano on plano.id = fk_plano group by plano.id;
  
  select * from plano where velocidade > 60;
  
  select count(*) as usuarios_plano from cliente group by fk_plano having usuarios_plano >= 3;
  
  select max(preco) from plano;
  
  select avg(preco) from plano;