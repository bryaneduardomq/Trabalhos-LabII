CREATE TABLE Cliente(
rg integer PRIMARY KEY,
nome VARCHAR(200),    
contato VARCHAR(15)
);

CREATE TABLE Aviao(
codAviao integer PRIMARY KEY,
nomeAviao VARCHAR(100),
qtAssentos int
);

CREATE TABLE Voo(
codVoo serial PRIMARY KEY,
origem VARCHAR(100),
destino VARCHAR(100),    
horario VARCHAR(100),
qtAssentosVoo int,    
codAviao int references Aviao(codAviao)
);

CREATE TABLE Venda(
codVenda serial PRIMARY KEY,
voo int references Voo(codVoo),
cliente int references Cliente(rg),
horarioCompra VARCHAR(100)
);

select * from voo

select * from venda

select * from cliente

select * from aviao