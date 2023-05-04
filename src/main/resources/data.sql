CREATE TABLE tbl_funcionario(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(20),
    nome VARCHAR(50) NOT NULL,
    funcao VARCHAR(45),
    nome_usuario VARCHAR(45) UNIQUE,
    senha VARCHAR(255)
);

CREATE TABLE tbl_departamento(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    numero_tramite INT
);

CREATE TABLE tbl_processo(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    numero_protocolo VARCHAR(15) NOT NULL UNIQUE,
    numero_requisicao VARCHAR(10),
    modalidade INT,
    descricao VARCHAR(255),
    departamento_origem INT,
    comprador INT
);

INSERT INTO `tbl_funcionario` (`matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('00001', 'Guto', 'Estagiário', 'guto', '1234');
INSERT INTO `tbl_funcionario` (`matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('00002', 'João', 'Comprador', 'joao', '3421');
INSERT INTO `tbl_funcionario` (`matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('00002', 'Mariana', 'Compradora', 'mariana', '54321');

INSERT INTO `tbl_departamento` (`nome`, `numero_tramite`) VALUES ('Secretaria de Educação', 1);
INSERT INTO `tbl_departamento` (`nome`, `numero_tramite`) VALUES ('Secretaria de Esportes e Lazer', 2);
INSERT INTO `tbl_departamento` (`nome`, `numero_tramite`) VALUES ('Secretaria de Obras', 3);

INSERT INTO `tbl_processo` (`numero_protocolo`, `numero_requisicao`, `modalidade`, `descricao`, `departamento_origem`, `comprador`) VALUES ('10001/1/2023', '0001', 1, 'Caderno de uma matéria com 48 folhas.', 1, 1);
INSERT INTO `tbl_processo` (`numero_protocolo`, `numero_requisicao`, `modalidade`, `descricao`, `departamento_origem`, `comprador`) VALUES ('20002/1/2023', '0002', 2, 'Bola de futebol de campo e jogo de coletes.', 2, 2);
INSERT INTO `tbl_processo` (`numero_protocolo`, `numero_requisicao`, `modalidade`, `descricao`, `departamento_origem`, `comprador`) VALUES ('30003/1/2023', '0003', 3, 'Pedra brita nº 01', 3, 3);
