var codigoMarca = 1;
var codigoProduto = 1;
var niveis = [1, 2, 3];


class Usuario {
    nome;
    login;
    senha;
    nivel;
    codigo;
    constructor(nome, login, senha, nivel) {
        this.nome = nome
        this.login = login
        this.senha = senha
        this.nivel = nivel
        this.codigo = Math.floor(Math.random() * 10000)
    }
}

class Marca {
    codigo;
    nome;
    constructor(nome) {
        this.nome = nome
        this.codigo =  Math.floor(Math.random() * 10000)

    }
}

class Produto {
    nome;
    valor;
    estoque;
    codigoMarca;
    codigo;
    categoria;
    constructor(nome, valor, estoque, codigoMarca, categoria) {
        this.nome = nome
        this.valor = valor
        this.estoque = estoque
        this.codigoMarca = codigoMarca
        this.categoria = categoria
        this.codigo =  Math.floor(Math.random() * 10000)

    }
}

class Venda {
    dia;
    nomeProduto;
    valorTotal;
    quantidade;
    codigoUsuario;
    constructor(dia, nomeProduto, valorTotal, codigoUsuario, quantidade){
        this.dia = dia;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.nomeProduto = nomeProduto;
        this.codigoUsuario = codigoUsuario;
        this.quantidade = quantidade;
    }
}
