
// Armazenar o indice do produto
var indiceProduto;

function salvarListaProdutos() {
    localStorage.setItem("produtos", JSON.stringify(produtos))
}


function cadastrarProduto() {

    // obter dados
    var nome = document.getElementById("txt-nome-produto")
    var valor = document.getElementById("txt-valor-produto")
    var estoque = document.getElementById("txt-estoque-produto")
    var codigoMarca = document.getElementById("marcas")
    var alertaProduto = document.getElementById("alerta-produto")
    let categorias = document.getElementById("categorias")


    ocultarAlertaProduto()

    if (nome.value == "") {
        alertaProduto.innerHTML = "Favor preencher o campo nome"
        alertaProduto.classList.add("alert", "alert-danger")
        nome.focus()
    }
    else if (valor.value == null || valor.value < 1) {
        alertaProduto.innerHTML = "Favor inserir um numero válido do campo valor"
        alertaProduto.classList.add("alert", "alert-danger")
        valor.focus()
    } else if (estoque.value == null || estoque.value < 1) {
        alertaProduto.innerHTML = "Favor inserir um numero válido do campo estoque"
        alertaProduto.classList.add("alert", "alert-danger")
        estoque.focus()
    } else if (codigoMarca.length < 1) {

        alertaProduto.innerHTML = "Nenhuma marca cadastrada"
        alertaProduto.classList.add("alert", "alert-danger")

        setTimeout(ocultarAlertaProduto, 2000)

    }
    else {


        let produto = new Produto(nome.value, valor.value, estoque.value, codigoMarca.value, categorias.value)

        produtos.push(produto);

        alertaProduto.innerHTML = "Cadastro efetuado"
        alertaProduto.classList.add("alert", "alert-success")

        setTimeout(ocultarAlertaProduto, 2000)
        resetarProduto()


        salvarListaProdutos()
        carregarCards()

    }
}

function selecionarProduto(index) {

    indiceProduto = index

    document.getElementById("btn-cadastrar-produto").style.display = "none"

    document.getElementById("btn-alterar-produto").style.display = "inline-block"
    document.getElementById("btn-remover-produto").style.display = "inline-block"
    document.getElementById("btn-cancelar-produto").style.display = "inline-block"

    let nome = document.getElementById("txt-nome-produto");
    let valor = document.getElementById("txt-valor-produto")
    let estoque = document.getElementById("txt-estoque-produto")
    let marcas = document.getElementById("marcas")

    let produto = produtos[index]

    console.log(produto.nome)

    nome.value = produto.nome
    valor.value = produto.valor
    estoque.value = produto.estoque

    console.log(produto.codigoMarca)

    marcas.value = produto.codigoMarca
}



function removerProduto() {

    let alertaProduto = document.getElementById("alerta-produto")


    produtos.splice(indiceProduto, 1)
    alertaProduto.innerHTML = "Produto removido"
    alertaProduto.classList.add("alert", "alert-danger")
    setTimeout(ocultarAlertaProduto, 1000)
    carregarCards()
    salvarListaProdutos()
    resetarProduto()
}


function alterarPrdouto() {

    console.log("OLA")

    var nome = document.getElementById("txt-nome-produto")
    var valor = document.getElementById("txt-valor-produto")
    var estoque = document.getElementById("txt-estoque-produto")
    var codigoMarca = document.getElementById("marcas")
    var alertaProduto = document.getElementById("alerta-produto")

    ocultarAlertaProduto()


    if (nome.value == "") {
        alertaProduto.innerHTML = "Favor preencher o campo nome"
        alertaProduto.classList.add("alert", "alert-danger")
        nome.focus()
    }
    else if (valor.value == null || valor.value < 1) {
        alertaProduto.innerHTML = "Favor inserir um numero válido do campo valor"
        alertaProduto.classList.add("alert", "alert-danger")
        valor.focus()
    } else if (estoque.value == null || estoque.value < 1) {
        alertaProduto.innerHTML = "Favor inserir um numero válido do campo estoque"
        alertaProduto.classList.add("alert", "alert-danger")
        estoque.focus()
    } else if (codigoMarca.length < 1) {

        alertaProduto.innerHTML = "Nenhuma marca cadastrada"
        alertaProduto.classList.add("alert", "alert-danger")

        setTimeout(ocultarAlertaProduto, 2000)

    } else {

        let produto = new Produto(nome.value, valor.value, estoque.value, codigoMarca.value)

        let codigo = produtos[indiceProduto].codigo

        produto.codigo = codigo


        produtos[indiceProduto] = produto;
        nome.focus()

        alertaProduto.innerHTML = "Produto alterado"
        alertaProduto.classList.add("alert", "alert-success")
        setTimeout(ocultarAlertaProduto, 1000)


        carregarCards();
        salvarListaProdutos();
        resetarProduto();
    }


    resetarProduto()
    setTimeout(ocultarAlertaProduto, 2000)

}

function resetarProduto() {

    document.getElementById("txt-nome-produto").value = "";
    document.getElementById("txt-valor-produto").value = "";
    document.getElementById("txt-estoque-produto").value = "";

    document.getElementById("btn-cadastrar-produto").style.display = "inline-block"
    document.getElementById("btn-alterar-produto").style.display = "none"
    document.getElementById("btn-remover-produto").style.display = "none"
    document.getElementById("btn-cancelar-produto").style.display = "none"

}



function ocultarAlertaProduto() {
    var alertaProduto = document.getElementById("alerta-produto")
    ocultarAlerta(alertaProduto)
}




function resgatarProdutos() {
    if (localStorage.getItem("produtos") != null) {
        produtos = JSON.parse(localStorage.getItem("produtos"))

    }


    if (localStorage.getItem("marcas") != null) {
        marcas = JSON.parse(localStorage.getItem("marcas"))



        let marcasSelect = document.getElementById("marcas");

        marcasSelect.innerHTML = ""

        for (let marca of marcas) {

            marcasSelect.innerHTML += ` <option value="${marca.codigo}">${marca.nome}</option>`

        }
    }
}

function limparCards() {
    let divProdutos = document.getElementById("produtos");

    divProdutos.innerHTML = "";
}

function carregarCards() {
    limparCards()

    criarDivs(produtos)

}

function criarDivs(produtos) {

    let divProdutos = document.getElementById("produtos");

    if (usuarioAtual.nivel == 3) {


        for (let i = 0; i < produtos.length; i++) {



            divProdutos.innerHTML += `<div class="col">
            <div class="card">
              <img src="https://th.bing.com/th/id/OIP.9_6iRUb1faXikdfnTU-HxwHaE8?pid=ImgDet&rs=1" class="card-img-top" alt="...">
              <div class="card-body">
                <h3 class="card-title">${produtos[i].nome}</h3>
                <p class="card-text">R$${produtos[i].valor}</p>
                <p class="card-text">Estoque: ${produtos[i].estoque}</p>
              </div>
              <hr>
              <button class="btn btn-success btn-produto-vender" onclick ="venderProduto(${i})">Vender</button> 
            </div>
          </div>
            `
        }

    }
    else {
        for (let i = 0; i < produtos.length; i++) {



            divProdutos.innerHTML += `<div class="col">
        <div class="card">
          <img src="https://th.bing.com/th/id/OIP.9_6iRUb1faXikdfnTU-HxwHaE8?pid=ImgDet&rs=1" class="card-img-top" alt="...">
          <div class="card-body">
            <h3 class="card-title">${produtos[i].nome}</h3>
            <p class="card-text">R$${produtos[i].valor}</p>
            <p class="card-text">Estoque: ${produtos[i].estoque}</p>
          </div>
          <hr>
          <button class="btn btn-primary btn-produto-selecionar" onclick ="selecionarProduto(${i})">Selecionar</button>
          <button class="btn btn-success btn-produto-vender" onclick ="venderProduto(${i})">Vender</button> 
        </div>
      </div>
        `
        }
    }
}



function carregarCardsPorFiltro() {

    let nomeFiltro = document.getElementById("nome-filtro").value
    goToMain()

    console.log(nomeFiltro)

    if (nomeFiltro != null && nomeFiltro != "") {


        limparCards()
        let produtosFiltro = produtos.filter(p => p.nome.toUpperCase() == nomeFiltro.toUpperCase())


        criarDivs(produtosFiltro)
    }

}

function venderProduto(index) {

    let produto = produtos[index]

    let quantidade = parseInt(prompt("Insira a quantidae do produto"))


    if (Number.isNaN(quantidade)) {
        alert("Erro, numero invalido")
    } else if (produto.estoque < quantidade) {
        alert("Erro, quantidade é maior que o estoque")
    }
    else {

        let valorTotal = produto.valor * quantidade;

        let venda = new Venda(Date.now(), produto.nome , valorTotal, usuarioAtual.codigo, quantidade)

        vendas.push(venda)

        alert("Valor total da venda: R$" + valorTotal)

        produtos[index].estoque -= quantidade;
        salvarListaProdutos()
        salvarListaVendas()
        carregarCards()

    }

}

function salvarListaVendas(){
    localStorage.setItem("vendas", JSON.stringify(vendas))
}

function resgatarVendas() {

    if (localStorage.getItem("vendas") != null) {
        vendas = JSON.parse(localStorage.getItem("vendas"))
    }

}
