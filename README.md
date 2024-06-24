# projeto_temperatura
Projeto mqtt que utiliza um sensor mqtt para mostrar a temperatura de um local

Segue sql para criação de tabelas relacionadas
--tabela pessoa
create table Pessoa(
id integer auto_increment primary key,
nome_completo varchar(200) not null,
usuario varchar(300) not null unique,
senha text not null, 
email varchar(15) not null unique
);
--tabela sensores 
CREATE TABLE sensores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL
);

--tabela temperatura (não utilizada na versão atual)
CREATE TABLE temperaturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DOUBLE NOT NULL,
    timestamp BIGINT NOT NULL
);

O projeto importa o exemplo dado em sala de aula.. para fazer a conexão com o broker 
