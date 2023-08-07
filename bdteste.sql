-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07/08/2023 às 05:05
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdteste`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(100) NOT NULL,
  `cpf_cliente` varchar(14) NOT NULL,
  `rg_cliente` varchar(12) NOT NULL,
  `email_cliente` varchar(100) NOT NULL,
  `endereco_cliente` varchar(100) DEFAULT NULL,
  `telefone_cliente` varchar(14) NOT NULL,
  `idade_cliente` int(11) NOT NULL,
  `data_nascimento_cliente` date NOT NULL,
  `sexo_cliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome_cliente`, `cpf_cliente`, `rg_cliente`, `email_cliente`, `endereco_cliente`, `telefone_cliente`, `idade_cliente`, `data_nascimento_cliente`, `sexo_cliente`) VALUES
(2, 'carlos', '111.111.111-11', '11.111.111-1', 'carlos@gmail.com', NULL, '(11)11111-1111', 17, '2005-11-11', '17'),
(3, 'João', '312.312.541-35', '23.131.321-3', 'joao@gmail.com', 'Rua 2', '(21)23123-1414', 17, '2005-08-25', 'Masculino'),
(5, 'Gabriel', '444.444.444-44', '33.333.333-3', 'gabriel@gmail.com', 'Rua 2', '(66)66666-6666', 18, '1969-12-31', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_estoque` int(11) NOT NULL,
  `lote` int(11) DEFAULT NULL,
  `secao` varchar(100) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `chegada` datetime(6) DEFAULT NULL,
  `saida` datetime(6) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `nome_funcionario` varchar(100) DEFAULT NULL,
  `cpf_funcionario` varchar(14) DEFAULT NULL,
  `rg_funcionario` varchar(12) DEFAULT NULL,
  `email_funcionario` varchar(100) DEFAULT NULL,
  `endereco_funcionario` varchar(100) DEFAULT NULL,
  `telefone_funcionario` varchar(14) DEFAULT NULL,
  `telefone2_funcionario` varchar(14) DEFAULT NULL,
  `idade_funcionario` int(11) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `sexo_funcionario` varchar(50) DEFAULT NULL,
  `turno` varchar(50) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `foto_funcionario` longblob DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `nome_funcionario`, `cpf_funcionario`, `rg_funcionario`, `email_funcionario`, `endereco_funcionario`, `telefone_funcionario`, `telefone2_funcionario`, `idade_funcionario`, `data_nascimento_funcionario`, `sexo_funcionario`, `turno`, `cargo`, `salario`, `foto_funcionario`, `senha`) VALUES
(1, 'admin', '111.111.111-11', '11.111.111-1', 'admn@gmail.com', 'rua', '(22)22222-2222', '(11)11111-1111', 23, '2000-07-04', 'Feminino', 'Tarde', 'Gerente', 1200, NULL, NULL),
(2, 'william', '111.111.111-11', '11.111.111-1', 'admn@gmail.com', 'rua 3', '(22)22222-2222', '(11)11111-1111', 21, '1970-01-01', 'Feminino', 'Tarde', 'Gerente', 1200, NULL, NULL),
(3, 'william', '111.111.111-11', '11.111.111-1', 'admn@gmail.com', 'rua 3', '(22)22222-2222', '(11)11111-1111', 21, '1970-01-01', 'Feminino', 'Tarde', 'Gerente', 1200, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `nome_produto` varchar(100) DEFAULT NULL,
  `nome_fornecedor` varchar(100) DEFAULT NULL,
  `codigo_produto` int(11) DEFAULT NULL,
  `data_registro` date DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `tamanho` varchar(100) DEFAULT NULL,
  `preco_produto` double DEFAULT NULL,
  `preco_compra` double DEFAULT NULL,
  `desconto` int(11) DEFAULT NULL,
  `foto` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_estoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
