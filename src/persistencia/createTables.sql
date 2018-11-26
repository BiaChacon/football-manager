CREATE TABLE IF NOT EXISTS TEAM (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR (50) NOT NULL,
    senha VARCHAR (8) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    dataFundacao DATE NOT NULL,
    patrimonio DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS ATLETA (
        nome VARCHAR(100) NOT NULL,
        cpf VARCHAR(15) NOT NULL PRIMARY KEY,
        dataNasc DATE NOT NULL,
        telefone VARCHAR(16) NOT NULL,
        email VARCHAR(100),
        endereco VARCHAR(200) NOT NULL,
        salario DOUBLE NOT NULL,
        ID_TEAM INTEGER NOT NULL
); 

CREATE TABLE IF NOT EXISTS JOGO (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dataHoraPartida VARCHAR(50) NOT NULL,
    localJogo  VARCHAR(100) NOT NULL, 
    adversario VARCHAR(100) NOT NULL, 
    competicao VARCHAR(100) NOT NULL,
    lucroPartida double,
    status BOOLEAN NOT NULL,
    stCouF BOOLEAN NOT NULL,
    ID_TEAM INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS PATROCINIO(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DOUBLE NOT NULL,
    ID_TEAM INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS DESPESA(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DOUBLE NOT NULL,
    ID_TEAM INTEGER NOT NULL
); 

CREATE TABLE IF NOT EXISTS FINANCEIRO(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dataBalanco DATE NOT NULL,
    patrocinios DOUBLE NOT NULL,
    despesas DOUBLE NOT NULL,
    lucroPartidas DOUBLE NOT NULL,
    salarios DOUBLE NOT NULL,
    total DOUBLE NOT NULL,
    ID_TEAM INTEGER NOT NULL
);

--PATROCINIO E FINANCEIRO
ALTER TABLE PATROCINIO ADD CONSTRAINT IF NOT EXISTS FK_PATROCINIO_TEAM FOREIGN KEY(ID_TEAM) 
REFERENCES TEAM (ID) ON DELETE CASCADE ON UPDATE CASCADE;

--DESPESA E FINANCEIRO
ALTER TABLE DESPESA ADD CONSTRAINT IF NOT EXISTS FK_DESPESA_TEAM FOREIGN KEY(ID_TEAM) 
REFERENCES TEAM (ID) ON DELETE CASCADE ON UPDATE CASCADE;

 --FINANCEIRO E TIME
ALTER TABLE FINANCEIRO ADD CONSTRAINT IF NOT EXISTS FK_FINANCEIRO_TEAM FOREIGN KEY(ID_TEAM) 
REFERENCES TEAM (ID) ON DELETE CASCADE ON UPDATE CASCADE;

--ATLETA E TIME
ALTER TABLE ATLETA ADD CONSTRAINT IF NOT EXISTS FK_ATLETA_TEAM FOREIGN KEY(ID_TEAM) 
REFERENCES TEAM (id) ON DELETE CASCADE ON UPDATE CASCADE;

--JOGO E TIME
ALTER TABLE JOGO ADD CONSTRAINT IF NOT EXISTS FK_JOGO_TEAM FOREIGN KEY(ID_TEAM) 
REFERENCES TEAM (ID) ON DELETE CASCADE ON UPDATE CASCADE;


