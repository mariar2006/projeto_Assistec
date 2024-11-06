CREATE DATABASE IF NOT EXISTS `lojabd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `lojabd`;

CREATE TABLE `usuarios` (
  `iduser` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `usuarios` (`iduser`, `nome`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'BELTRANO FERREIRA', '1199999-9999', 'beltrano', '1234', 'admin'),
(2, 'FULANO DA SILVA', '1199999-9999', 'fulano', '1234', 'admin'),
(3, 'ZEZINHO XAVIER', '1199999-9999', 'zezinho', '1234', 'user');

SELECT * FROM USUARIOS;

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `login` (`login`);

ALTER TABLE `usuarios`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
  
  
