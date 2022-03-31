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

INSERT INTO marcas (nome) VALUES
("Apple"),
("Sony"),
("Samsung"),
("Nike"),
("Nestle");


INSERT INTO produtos (nome, valor, categoria, quantidade, marca_id) VALUES
("Galaxy s21", 7000, "ELETRONICO", 3,   3),
("Iphone 12", 6500,"ELETRONICO", 2,  1),
("TV 4K", 1500,"ELETRONICO", 7,  2),
("Nescau", 20,"ALIMENTACAO", 12,  5),
("Whey Concentrado", "88","ALIMENTACAO", 9,  4),
("Camiseta", "32","ROUPA", 9,  4);

select * from produtos;
