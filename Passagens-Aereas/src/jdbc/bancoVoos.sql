CREATE TABLE Cliente(
rg integer PRIMARY KEY,
nome VARCHAR(200) NOT NULL,    
contato VARCHAR(15) NOT NULL
);

CREATE TABLE Aviao(
codAviao integer PRIMARY KEY,
nomeAviao VARCHAR(100) NOT NULL,
qtAssentos int NOT NULL
);

CREATE TABLE Voo(
idVoo serial PRIMARY KEY,
origem VARCHAR(100) NOT NULL,
destino VARCHAR(100) NOT NULL,    
horario VARCHAR(100) NOT NULL,
qtAssentosVoo int NOT NULL,    
codAviao integer references Aviao(codAviao) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Venda(
codVenda serial PRIMARY KEY,
voo serial references Voo(codVoo) ON DELETE CASCADE ON UPDATE CASCADE,
cliente integer references Cliente(rg) ON DELETE CASCADE ON UPDATE CASCADE,
horarioCompra VARCHAR(100) NOT NULL
);

select * from voo

select * from venda

select * from cliente

select * from aviao

