create database empresa;
use empresa;

create table departamento (
	depto_nro varchar(10) primary key
    , nome_depto varchar(50)
    , localizacao varchar(50)
);

insert into departamento values
	("D-000-1", "Software", "Los Tigres"),
	("D-000-2", "Sistemas", "Guadalupe"),
	("D-000-3", "Contabilidade", "La Roca"),
	("D-000-4", "Vendas", "Plata");
    
create table funcionario (
	cod_fuc varchar(10) primary key
    , nome varchar(50)
    , sobrenome varchar(50)
    , cargo varchar(50)
    , data_alta date
    , salario int
    , comissao int
    , depto_nro varchar(10)
    , constraint depto_nro foreign key (depto_nro) references departamento (depto_nro)
);

insert into funcionario values
	("E=0001", "César", "Piñero", "Vendedor", "2018-12-05", 80000, 15000, "D-000-4"),
	("E=0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", 140000, 0, "D-000-2"),
	("E=0003", "Mariela", "Barrios", "Diretor", "2014-06-05", 185000, 0, "D-000-3"),
	("E=0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-000-4"),
	("E=0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-000-4"),
	("E=0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, "D-000-3"),
	("E=0007", "Emilio", "Galarza", "Desenvolvedor", "2014-08-02", 60000, 0, "D-000-1");
    
# 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores trabalham.
select * from departamento where depto_nro in (select depto_nro from funcionario where cargo = "Vendedor");
# 2. Visualize departamentos com mais de cinco funcionários.
select depto_nro, count(*) as qtd_funcionarios from funcionario group by depto_nro having qtd_funcionarios > 5;
# 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo cargo que 'Mito Barchuk'.
select cod_fuc, nome, sobrenome, salario, nome_depto, funcionario.depto_nro from funcionario join departamento where cargo = 
	(select cargo from funcionario where concat(nome, ' ', sobrenome) = "Mito Barchuk") and departamento.depto_nro = funcionario.depto_nro;
# 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade, ordenados por nome.
select * from funcionario where depto_nro = (select depto_nro from departamento where nome_depto = "Contabilidade") order by nome;
# 5. Mostre o nome do funcionário que tem o menor salário.
select nome from funcionario where salario = (select min(salario) from funcionario);
# 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
select * from funcionario where salario = (select max(salario) from funcionario where depto_nro = 
	(select depto_nro from departamento where nome_depto = "Vendas"));
