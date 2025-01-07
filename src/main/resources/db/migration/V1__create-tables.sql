CREATE TABLE grupos (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    grupo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE usuarios (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(150) NOT NULL,
    grupo_id UUID REFERENCES grupos(id) ON DELETE SET NULL,
    permissao VARCHAR(5) NOT NULL
);

CREATE TABLE compras (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    valor NUMERIC(15, 2) NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    status VARCHAR(8) NOT NULL,
    usuario_id UUID REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE pagamentos (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    forma_pagamento VARCHAR(8) NOT NULL,
    valor_total NUMERIC(15, 2) NOT NULL,
    quantidade_parcelas INT NOT NULL,
    compra_id UUID UNIQUE REFERENCES compras(id) ON DELETE CASCADE
);

CREATE TABLE parcelas (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    valor NUMERIC(15, 2) NOT NULL,
    numero INT NOT NULL,
    pagamento_id UUID REFERENCES pagamentos(id) ON DELETE CASCADE
);
