create database dbprojeto;
use dbprojeto;

create table tbusuario (
	pk_usuario int primary key auto_increment,
    nomeUsu varchar(60) not null,
    emailUsu varchar(40) not null unique,
    senhaUsu varchar(30) not null,
    dataNascUsu varchar(10) not null,
    ativoUsu tinyint not null
);
insert into tbusuario (nomeUsu, emailUsu, senhaUsu, dataNascUsu, ativoUsu) 
values ("adm", "adm@adm.com", "123", "01/01/2000", 1);


create table tbJogos (
pk_jogo int primary key auto_increment,
nomeJogo varchar(80) not null,
generoJogo varchar(30) not null,
produtoraJogo varchar(40) not null,
dataLanJogo varchar(10) not null,
classfiJogo varchar(3) not null,
imagemJogo blob(5242880),
descricaoJogo varchar(1000) not null
);
