CREATE DATABASE IF NOT EXISTS MoneyView;
USE MoneyView;

-- ======= TABELA USUÁRIOS =======
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(200) NOT NULL
);

-- ======= TABELA CATEGORIAS =======
CREATE TABLE categorias (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

-- ======= TABELA TRANSAÇÕES =======
CREATE TABLE transacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data DATE NOT NULL,
    tipo ENUM('income', 'expense') NOT NULL,
    categoria_id INT NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- ======= DADOS DE TESTE =======
INSERT INTO usuarios (nome_usuario, email, senha)
VALUES 
    ('john_doe', 'john@example.com', MD5('senha123')),
    ('jane_smith', 'jane@example.com', MD5('senha456')),
    ('alice_wonder', 'alice@example.com', MD5('senha789'));
    
INSERT INTO categorias (nome)
VALUES 
    ('Alimentação'),
    ('Transporte'),
    ('Lazer'),
    ('Salário'),
    ('Investimentos');
    
INSERT INTO transacoes (descricao, valor, data, tipo, categoria_id, usuario_id)
VALUES 
    ('Supermercado', 150.75, '2023-10-01', 'expense', 1, 1),
    ('Uber', 25.50, '2023-10-02', 'expense', 2, 1),
    ('Cinema', 40.00, '2023-10-03', 'expense', 3, 2),
    ('Salário', 3000.00, '2023-10-05', 'income', 4, 3),
    ('Ações', 500.00, '2023-10-10', 'income', 5, 3),
    ('Restaurante', 80.00, '2023-10-15', 'expense', 1, 2);

-- ======= CONSULTAS =======
SELECT * FROM usuarios;
SELECT * FROM categorias;
SELECT * FROM transacoes;