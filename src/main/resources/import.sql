INSERT INTO tb_vendedor (nome, email) VALUES ('João Silva', 'joao.silva@example.com');
INSERT INTO tb_vendedor (nome, email) VALUES ('Maria Oliveira', 'maria.oliveira@example.com');
INSERT INTO tb_vendedor (nome, email) VALUES ('Carlos Souza', 'carlos.souza@example.com');
INSERT INTO tb_vendedor (nome, email) VALUES ('Ana Costa', 'ana.costa@example.com');
INSERT INTO tb_vendedor (nome, email) VALUES ('Felipe Almeida', 'felipe.almeida@example.com');

-- Inserção 1: Total = 1000.50
INSERT INTO tb_venda (total, data, comissao, status, id_vendedor)VALUES (1000.50, '2024-10-15', 100.05, 'BAIXA', 1);

-- Inserção 2: Total = 500.20
INSERT INTO tb_venda (total, data, comissao, status, id_vendedor) VALUES (500.20, '2024-10-16', 50.02, 'BAIXA', 2);

-- Inserção 3: Total = 2500.00
INSERT INTO tb_venda (total, data, comissao, status, id_vendedor) VALUES (2500.00, '2024-10-17', 250.00, 'BAIXA', 3);

-- Inserção 4: Total = 15000.75
INSERT INTO tb_venda (total, data, comissao, status, id_vendedor) VALUES (15000.75, '2024-10-18', 1500.08, 'MÉDIA', 4);

-- Inserção 5: Total = 35000.99
INSERT INTO tb_venda (total, data, comissao, status, id_vendedor) VALUES (35000.99, '2024-10-19', 3500.10, 'ALTA', 5);

