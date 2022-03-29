CREATE DATABASE ecommerce;

USE ecommerce;

CREATE TABLE marcas (
codigo int not null primary key auto_increment,
nome VARCHAR(50) not null
);

CREATE TABLE produtos (
codigo int not null primary key auto_increment,
nome VARCHAR(50) NOT NULL,
valor DOUBLE NOT NULL,
categoria VARCHAR(30),
quantidade int not null,
marca_id int not null,

foreign key(marca_id) references marcas(codigo)
);


CREATE VIEW visao AS
SELECT
 produtos.codigo,
 produtos.nome,
 produtos.valor,
 produtos.quantidade,
 produtos.categoria,
 marcas.nome AS marca
 FROM produtos
 INNER JOIN marcas
 ON marcas.codigo = produtos.marca_id;
 
 select nome, valor, quantidade, categoria, marca from visao;


-- //////////////////////

INSERT INTO marcas (nome) VALUES
("Apple"),
("Sony"),
("Samsung"),
("Growth"),
("Nestle");


INSERT INTO produtos (nome, valor, categoria, quantidade, marca_id) VALUES
("Galaxy s21", 7000, "ELETRONICO", 3,   3),
("Iphone 12", 6500,"ELETRONICO", 2,  1),
("TV 4K", 1500,"ELETRONICO", 7,  2),
("Nescau", 20,"ALIMENTACAO", 12,  5),
("Whey Concentrado", "88","ALIMENTACAO", 9,  4),
("Regata", "32","ROUPA", 9,  4);

select * from produtos;
