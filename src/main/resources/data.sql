CREATE TABLE tbl_funcionario(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(20),
    nome VARCHAR(50) NOT NULL,
    funcao VARCHAR(45),
    nome_usuario VARCHAR(45) UNIQUE,
    senha VARCHAR(255)
);
INSERT INTO `tbl_funcionario` (`id`, `matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('1', '00001', 'Guto', 'Estagiário', 'guto', '1234');
INSERT INTO `tbl_funcionario` (`id`, `matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('2', '00002', 'João', 'Comprador', 'joao', '3421');
INSERT INTO `tbl_funcionario` (`id`, `matricula`, `nome`, `funcao`, `nome_usuario`, `senha`) VALUES ('3', '00002', 'Mariana', 'Compradora', 'mariana', '54321');