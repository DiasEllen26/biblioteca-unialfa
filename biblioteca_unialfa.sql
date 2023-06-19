-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Tempo de geração: 19/06/2023 às 23:27
-- Versão do servidor: 5.7.34
-- Versão do PHP: 8.0.8

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `biblioteca_unialfa`
--
CREATE DATABASE IF NOT EXISTS `biblioteca_unialfa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `biblioteca_unialfa`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Aluno`
--

DROP TABLE IF EXISTS `Aluno`;
CREATE TABLE `Aluno` (
  `id` bigint(20) NOT NULL,
  `ra` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `telefone` int(11) NOT NULL,
  `curso_id` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Aluno`
--

TRUNCATE TABLE `Aluno`;
-- --------------------------------------------------------

--
-- Estrutura para tabela `Autor`
--

DROP TABLE IF EXISTS `Autor`;
CREATE TABLE `Autor` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `telefone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Autor`
--

TRUNCATE TABLE `Autor`;
-- --------------------------------------------------------

--
-- Estrutura para tabela `Curso`
--

DROP TABLE IF EXISTS `Curso`;
CREATE TABLE `Curso` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `coorenador` varchar(255) NOT NULL,
  `duracao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Curso`
--

TRUNCATE TABLE `Curso`;
-- --------------------------------------------------------

--
-- Estrutura para tabela `Editora`
--

DROP TABLE IF EXISTS `Editora`;
CREATE TABLE `Editora` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `telefone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Editora`
--

TRUNCATE TABLE `Editora`;
-- --------------------------------------------------------

--
-- Estrutura para tabela `Livro`
--

DROP TABLE IF EXISTS `Livro`;
CREATE TABLE `Livro` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `subTitulo` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `autor_id` bigint(11) NOT NULL,
  `editora_id` bigint(11) NOT NULL,
  `local` varchar(255) NOT NULL,
  `ano` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Livro`
--

TRUNCATE TABLE `Livro`;
-- --------------------------------------------------------

--
-- Estrutura para tabela `Reserva`
--

DROP TABLE IF EXISTS `Reserva`;
CREATE TABLE `Reserva` (
  `id` bigint(20) NOT NULL,
  `aluno_id` bigint(20) NOT NULL,
  `livro_id` bigint(20) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `observacao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabela truncada antes do insert `Reserva`
--

TRUNCATE TABLE `Reserva`;
--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `Aluno`
--
ALTER TABLE `Aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `AlunoToCurso` (`curso_id`);

--
-- Índices de tabela `Autor`
--
ALTER TABLE `Autor`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Curso`
--
ALTER TABLE `Curso`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Editora`
--
ALTER TABLE `Editora`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Livro`
--
ALTER TABLE `Livro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `LivroToAutor` (`autor_id`),
  ADD KEY `LivroToEditora` (`editora_id`);

--
-- Índices de tabela `Reserva`
--
ALTER TABLE `Reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ReservaToAluno` (`aluno_id`),
  ADD KEY `ReservaToLivro` (`livro_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `Aluno`
--
ALTER TABLE `Aluno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Autor`
--
ALTER TABLE `Autor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Curso`
--
ALTER TABLE `Curso`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Editora`
--
ALTER TABLE `Editora`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Livro`
--
ALTER TABLE `Livro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Reserva`
--
ALTER TABLE `Reserva`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `Aluno`
--
ALTER TABLE `Aluno`
  ADD CONSTRAINT `AlunoToCurso` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`);

--
-- Restrições para tabelas `Livro`
--
ALTER TABLE `Livro`
  ADD CONSTRAINT `LivroToAutor` FOREIGN KEY (`autor_id`) REFERENCES `Autor` (`id`),
  ADD CONSTRAINT `LivroToEditora` FOREIGN KEY (`editora_id`) REFERENCES `Editora` (`id`);

--
-- Restrições para tabelas `Reserva`
--
ALTER TABLE `Reserva`
  ADD CONSTRAINT `ReservaToAluno` FOREIGN KEY (`aluno_id`) REFERENCES `Aluno` (`id`),
  ADD CONSTRAINT `ReservaToLivro` FOREIGN KEY (`livro_id`) REFERENCES `Livro` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
