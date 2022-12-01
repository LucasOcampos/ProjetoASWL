drop database db_solid_pdv_lp3; 
create database  db_solid_pdv_lp3;
use db_solid_pdv_lp3;




create table tb_usuario(
id_usuario int auto_increment primary key,
nome varchar(100) not null,
login varchar(100) not null unique,
senha varchar(10) not null,
telefone varchar(18),
cpf varchar(18) unique,
cnpj varchar(20) unique
);
create table tb_venda(
id_venda int auto_increment primary key,
data datetime not null,
valorCompra decimal(10,2) not null,
fk_id_usuario int,
constraint fk_id_usuario_vendas foreign key(fk_id_usuario) references tb_usuario(id_usuario)
);

create table tb_cad_produto(
id_cad_produto int auto_increment primary key,
cod_barra char(13) not null unique,
descricao varchar(50) not null,
preco_custo decimal(20,2), 
preco_venda decimal(20,2),
qtd_estoque int,
categoria varchar(50)
);

select * from tb_usuario;
select * from tb_cad_produto;
select * from tb_cad_produto where cod_barra ="2000" or descricao ="" ;
select * from tb_cad_produto;

/*create table

select * from tb_usuario;

/*select * from tb_usuario;
select * from tb_cad_produto where cod_barra = 2000;
select * from tb_cad_produto;
insert into tb_cad_produto(cod_barra, descricao, preco_custo, preco_venda, qtd_estoque,categoria)values(200,'Acucar',12.50,15.75,15,'mercearia');
describe tb_cad_produto;*/