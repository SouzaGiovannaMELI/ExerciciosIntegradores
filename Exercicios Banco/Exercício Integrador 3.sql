# Exercicio 1
# 1. Listar os dados dos autores.
select * from autor;
# 2. Listar nome e idade dos alunos
select nome, idade from aluno;
# 3. Quais alunos pertencem à carreira de informática?
select nome from aluno where carreira like "%Programador%";
# 4. Quais autores são de nacionalidade francesa ou italiana?
select nome from autor where nacionalidade = "França" or nacionalidade = "Italia";
# 5. Que livros não são da área da internet?
select titulo from livro where area not like "internet";
# 6. Listar os livros da editora Salamandra.
select titulo from livro where editoria = "Salamandra";
# 7. Listar os dados dos alunos cuja idade é maior que a média.
select * from aluno having idade > (select avg(idade) from aluno);
# 8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.
select nome from aluno where nome like "G%";
# 9. Listar os autores do livro "A rainha vermelha". (Apenas nomes devem ser listados)
select nome from autor where idAutor = 
	(select idAutor from livroAutor where idAutor = autor.idAutor and idLivro = 
		(select idLivro from livro where titulo = "A rainha vermelha")); 
# 10. Listar autores que tenham nacionalidade americana ou argentina.
select nome from autor where nacionalidade = "EUA" or nacionalidade = "Argentina";
# 11. Que livros foram emprestados ao leitor “Giovanna Souza”?
select titulo from livro where idLivro in 
	(select idLivro from emprestimo where idLeitor = 
		(select idAluno from aluno where concat(nome, ' ', sobrenome) = "Giovanna Souza"));
# 12. Listar o nome do aluno mais novo.
select nome from aluno where idade = (select min(idade) from aluno);
# 13. Listar os nomes dos alunos a quem os livros de Banco de Dados foram emprestados.
select nome from aluno where idAluno in (select idLeitor from emprestimo where idLeitor = idAluno);
# 14. Listar os livros que pertencem ao autor J.K. Rowling.
select titulo from livro where idLivro in 
	(select idLivro from livroAutor where idAutor = 
		(select idAutor from autor where nome = "J. K. Rowling"));
# 15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.
select titulo from livro where idLivro in 
	(select idLivro from emprestimo where data_devolucao < "2021-02-16");
# Exercicio 2
# Implemente o banco de dados no MySQL Workbench, carregue cinco registros em cada tabela e tente algumas consultas levantadas no Exercício 1.
create database biblioteca;
use biblioteca;

create table autor (
	idAutor int primary key auto_increment
    , nome varchar(100)
    , nacionalidade varchar(100)
);

create table livro (
	idLivro int primary key auto_increment
    , titulo varchar(100)
    , editoria varchar(100)
    , area varchar(100)
);

create table aluno (
	idAluno int primary key auto_increment
    , nome varchar(50)
    , sobrenome varchar(100)
    , endereco varchar(100)
    , carreira varchar(100)
    , idade int
);

create table livroAutor (
	idLivro int 
    , idAutor int
    , constraint idLivro foreign key (idLivro) references livro (idLivro)
    , constraint idAutor foreign key (idAutor) references autor (idAutor)
);

create table emprestimo (
	idLeitor int
    , idLivro int
    , data_emprestimo date
    , data_devolucao date
    , retornou boolean
    , constraint idLeitor foreign key (idLeitor) references aluno (idAluno)
    , constraint idLivroEmprestado foreign key (idLivro) references livro (idLivro)
);

# carregue cinco registros em cada tabela
insert into `autor` (`nome`,`nacionalidade`) values
  ("J. K. Rowling","Reino Unido"),
  ("Kiera Cass","EUA"),
  ("Victoria Aveyard","EUA"),
  ("Lisa McMann","EUA"),
  ("Soman Chainani","EUA");
  
insert into `livro` (`titulo`,`editoria`,`area`) values
  ("A escola do bem e do mal","Pennington","Infantojuvenil"),
  ("Harry Potter e a ordem da fenix","Farrell","infantojuvenil"),
  ("Wake","Macias","juvenil"),
  ("A seleção","Cummings","juvenil"),
  ("A rainha vermelha","Mccarty","juvenil");
  
insert into `aluno` (`nome`,`sobrenome`,`endereco`,`carreira`,`idade`) values
	("Giovanna", "Souza", "Av Aguia de Haia", "Programadora", 19),
	("Italo", "Bruno", "Itaim Paulista", "Programador", 19),
	("Alexandre", "Alves", "Tatuapé", "Programador", 36),
	("Lucas", "Gonçalves", "Itaquera", "Programador", 18),
	("Camille", "Vieira", "Guaianazes", "Biomédica", 19);
    
insert into `livroAutor` values (2, 1), (1, 5), (3, 4), (4, 2), (5, 3);

insert into `emprestimo` values 
(1, 2, "2022-10-11", "2022-11-11", true),
(5, 4, "2020-10-11", "2020-11-11", false),
(2, 2, "2010-10-11", "2010-11-11", true),
(1, 5, "2021-10-11", "2021-11-11", true),
(4, 2, "2018-10-11", "2018-11-11", false);