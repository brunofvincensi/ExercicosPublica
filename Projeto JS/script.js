var codigoUsuario = 0;
var codigoMarca = 0;
var codigoProduto = 0;

var niveis = [1, 2, 3]; 


class Usuario{
    nome;
    login;
    senha;
    nivel;
    constructor(nome, login, senha, nivel){
        this.nome = nome
        this.login = login
        this.senha = senha
        this.nivel = nivel
    }
}

class Marca{
    nome;
    constructor(nome){
        this.nome = nome
    }
}

class Produto{
    nome;
    valor;
    estoque;
    constructor(nome, valor, estoque){
        this.nome = nome
        this.valor = valor
        this.estoque = estoque
    }
}


var usuarios = []
var marcas = []
var produtos = []

usuarios.push(new Usuario("Bruno", "admin", "admin", niveis[0]))




