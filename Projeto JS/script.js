

function validaLogin() {

    console.log("ola")

    let login = document.getElementById("txt-login")
    let senha = document.getElementById("txt-senha")
    var alerta = document.getElementById("alerta")
    ocultarAlerta();
    alerta.classList.remove("alert", "alert-danger", "alert-success")


    if (login.value == "") {

        alerta.innerHTML = "Favor preencher o campo login"
        alerta.classList.add("alert", "alert-danger")
        login.focus()
    }
    else if (senha.value == "") {
        alerta.innerHTML = "Favor preencher o campo senha"
        alerta.classList.add("alert", "alert-danger")
        senha.focus()
    } else {

        existe = false;

        for (let usuario of usuarios) {
            if (usuario.login == login.value && usuario.senha == senha.value) {


                existe = true;
                break;

            }
        }

        if (existe) {
            let formLogin = document.getElementById("form-login");

            let pgVendas = document.getElementById("vendas")

            let body = document.getElementsByTagName("body");

            body[0].style.display = "inline"

            formLogin.style.display = "none"
            pgVendas.style.display = "flex"
        }
        else {
            alerta.innerHTML = "Login ou senha incorretos"
            alerta.classList.add("alert", "alert-danger")
            login.focus()
        }

    }
}

// Cadastrar
function cadastrar() {

    // obter dados
    var nome = document.getElementById("txt-nome-produto")
    var valor = document.getElementById("num-valor")
    var estoque = document.getElementById("num-estoque")
    var codigoMarca = document.getElementById("marcas")
    var alertaProduto = document.getElementById("alerta-produto")

    alertaProduto.classList.remove("alert", "alert-danger", "alert-success")

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


        let produto = new Produto(nome.value, valor.value, estoque.value, codigoMarca.value)

        produtos.push(produto);

        alertaProduto.innerHTML = "Cadastro efetuado"
        alertaProduto.classList.add("alert", "alert-success")
        setTimeout(() => {
            ocultarAlerta(alerta)
        }, 2000)


        produtos.forEach(x => console.log(x))
        limparCards()
        carregarCards()

    }
}

function selecionarProduto(id) {
    console.log(id)
}


function ocultarAlertaProduto() {
    var alertaProduto = document.getElementById("alerta-produto")
    ocultarAlerta(alertaProduto)
}


function ocultarAlerta(alerta) {

    alerta.classList.remove("alert", "alert-danger", "alert-success")
    alerta.innerHTML = "";
}



window.onload = () => {
    carregarCards()
    listarUsuarios();

    let marcasSelect = document.getElementById("marcas");



    for (let marca of marcas) {

        marcasSelect.innerHTML += ` <option value="${marca.codigo}">${marca.nome}</option>`

    }

}

function limparCards(){
    let divProdutos = document.getElementById("produtos");

    divProdutos.innerHTML = "";
}

function carregarCards() {
    limparCards()
    let divProdutos = document.getElementById("produtos");

    for (let i = 0; i < produtos.length; i++) {

        divProdutos.innerHTML += `<div class="col">
        <div class="card">
          <img src="..." class="card-img-top" alt="...">
          <div class="card-body">
            <h3 class="card-title">${produtos[i].nome}</h3>
            <p class="card-text">R$${produtos[i].valor}</p>
          </div>
          <button class="btn btn-secondary btn-produto" onclick ="selecionarProduto(${produtos[i].codigo})">Selecionar</button> 
        </div>
      </div>
        `
    }

}

function carregarCardsPorFiltro(){
    limparCards()
    goToMain()

    let nomeFiltro = document.getElementById("nome-filtro").value

    let divProdutos = document.getElementById("produtos");


    let produtosFiltro = produtos.filter(p => p.nome == nomeFiltro)

    for (let i = 0; i < produtosFiltro.length; i++) {

        divProdutos.innerHTML += `<div class="col">
        <div class="card">
          <img src="..." class="card-img-top" alt="...">
          <div class="card-body">
            <h3 class="card-title">${produtosFiltro[i].nome}</h3>
            <p class="card-text">R$${produtosFiltro[i].valor}</p>
          </div>
          <button class="btn btn-secondary btn-produto" onclick ="selecionar(${produtosFiltro[i].codigo})">Selecionar</button> 
        </div>
      </div>
        `
    }

}


// Verificar se há algum dado no LocalSorage

