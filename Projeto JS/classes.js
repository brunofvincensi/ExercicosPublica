var codigoMarca = 1;
var codigoProduto = 1;
var niveis = [1, 2, 3];


class Usuario {
    nome;
    login;
    senha;
    nivel;
    constructor(nome, login, senha, nivel) {
        this.nome = nome
        this.login = login
        this.senha = senha
        this.nivel = nivel
    }
}

class Marca {
    codigo;
    nome;
    constructor(nome, codigo) {
        this.nome = nome
        this.codigo = codigo
    }
}

class Produto {
    nome;
    valor;
    estoque;
    codigoMarca;
    codigo;

    constructor(nome, valor, estoque, codigoMarca) {
        this.nome = nome
        this.valor = valor
        this.estoque = estoque
        this.codigoMarca = codigoMarca
        this.codigo = codigoProduto
        codigoProduto++;

    }
}