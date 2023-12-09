CREATE DATABASE IF NOT EXISTS `projeto_final`;

USE `projeto_final`;

CREATE TABLE `pessoas` (
	`cpf` bigint NOT NULL PRIMARY KEY,
	`rg` bigint  NOT NULL,
    `nome` text,
	`endereco` varchar(200),
    `numero` int (6),
	`estado` varchar(2),
    `telefone` bigint ,
    `ativo`char,
    `obs` text,
    `bairro` varchar(100),
    `cidade` varchar (100),
    `apto` int (4),
    `cep` bigint 
);
  
CREATE TABLE `clientes` (
	`codCliente` integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `fk_Cpf` bigint (11) NOT NULL,
    `qntPedidos` integer,
	`divida` float,
    `credito` float,

  FOREIGN KEY (fk_Cpf)
        REFERENCES pessoas (cpf) 
);

  CREATE TABLE `pedidos` (
	`codPedido` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `qtd_produto` float NOT NULL,
    `valor_produtos` float NOT NULL,
	`entrega` date NOT NULL,
    `pagamento` boolean NOT NULL,
    `data_pagamento` date    
);

  CREATE TABLE `pedido_cliente` (
	`fk_codPedido` integer NOT NULL,
    `fk_codCliente` integer NOT NULL,
    
	FOREIGN KEY (fk_codPedido)
        REFERENCES pedidos (codPedido),
        
	FOREIGN KEY (fk_codCliente)
        REFERENCES clientes (codCliente)
);


