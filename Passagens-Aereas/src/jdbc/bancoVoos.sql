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
codVoo integer PRIMARY KEY,
origem VARCHAR(100),
destino VARCHAR(100),    
horario VARCHAR(100),
qtAssentosVoo int,    
codAviao int references Aviao(codigo)
);

CREATE TABLE Venda(
codVenda integer PRIMARY KEY,
horarioCompra VARCHAR(100),
cliente int references Cliente(rg),
voo int references Voo(codVoo)
);







