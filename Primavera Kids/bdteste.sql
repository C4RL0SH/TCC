-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Ago-2023 às 14:03
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.0.25

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
-- Estrutura da tabela `cliente`
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
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome_cliente`, `cpf_cliente`, `rg_cliente`, `email_cliente`, `endereco_cliente`, `telefone_cliente`, `idade_cliente`, `data_nascimento_cliente`, `sexo_cliente`) VALUES
(2, 'carlos', '111.111.111-11', '11.111.111-1', 'carlos@gmail.com', NULL, '(11)11111-1111', 17, '2005-11-11', '17'),
(3, 'João', '312.312.541-35', '23.131.321-3', 'joao@gmail.com', 'Rua 2', '(21)23123-1414', 17, '2005-08-25', 'Masculino'),
(5, 'Gabriel', '444.444.444-44', '33.333.333-3', 'gabriel@gmail.com', 'Rua 2', '(66)66666-6666', 18, '1969-12-31', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
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
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `nome_funcionario` varchar(100) DEFAULT NULL,
  `email_funcionario` varchar(100) DEFAULT NULL,
  `cpf_funcionario` varchar(14) DEFAULT NULL,
  `rg_funcionario` varchar(12) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `idade_funcionario` int(11) DEFAULT NULL,
  `telefone_funcionario` varchar(14) DEFAULT NULL,
  `telefone2_funcionario` varchar(14) DEFAULT NULL,
  `endereco_funcionario` varchar(100) DEFAULT NULL,
  `sexo_funcionario` varchar(50) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `turno` varchar(50) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `foto_funcionario` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `nome_funcionario`, `email_funcionario`, `cpf_funcionario`, `rg_funcionario`, `data_nascimento_funcionario`, `idade_funcionario`, `telefone_funcionario`, `telefone2_funcionario`, `endereco_funcionario`, `sexo_funcionario`, `cargo`, `turno`, `salario`, `senha`, `foto_funcionario`) VALUES
(1, 'admin', 'admn@gmail.com', '111.111.111-11', '11.111.111-1', '2000-07-04', 23, '(22)22222-2222', '(11)11111-1111', 'rua', 'Feminino', 'Gerente', 'Tarde', 1200, '123', NULL),
(2, 'william', 'admn@gmail.com', '111.111.111-11', '11.111.111-1', '1970-01-01', 21, '(22)22222-2222', '(11)11111-1111', 'rua 3', 'Feminino', 'Gerente', 'Tarde', 1200, NULL, NULL),
(3, 'william', 'admn@gmail.com', '111.111.111-11', '11.111.111-1', '1970-01-01', 21, '(22)22222-2222', '(11)11111-1111', 'rua 3', 'Feminino', 'Gerente', 'Tarde', 1200, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
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
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- AUTO_INCREMENT de tabelas despejadas
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
