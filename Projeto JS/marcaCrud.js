// Armazenar o indice da marca
var indiceMarca;

function salvarListaMarcas() {
    localStorage.setItem("marcas", JSON.stringify(marcas))
}

function cadastrarMarca() {
    console.log("olaa")

    let nome = document.getElementById("txt-nome-marca");

    let alertaMarca = document.getElementById("alerta-marca")

    ocultarAlertaMarca()

    if (nome.value == "") {
        alertaMarca.innerHTML = "Favor preencher o campo nome"
        alertaMarca.classList.add("alert", "alert-danger")
        nome.focus()
    }

    else {

        let marca = new Marca(nome.value)

        marcas.push(marca)

        alertaMarca.innerHTML = "Cadastro efetuado"
        alertaMarca.classList.add("alert", "alert-success")
        setTimeout(ocultarAlertaMarca, 2000)

        listarMarcas()
        salvarListaMarcas();

    }
}

function ocultarAlertaMarca() {
    var alertaMarca = document.getElementById("alerta-marca")
    ocultarAlerta(alertaMarca)
}

function listarMarcas() {

    //Obter o tbody
    var tabela = document.getElementById("tabela-marca")

    // Limpar tbody
    tabela.innerHTML = "";


    // Laço
    for (let i = 0; i < marcas.length; i++) {

        // Linha da tabela
        var linha = tabela.insertRow(i)

        // Colunas
        var colunaCodigo = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaQntdProdutos = linha.insertCell(2)
        colunaSelecionar = linha.insertCell(3)


        // Enviar dados do JSON
        colunaNome.innerHTML = marcas[i].nome
        colunaCodigo.innerHTML = marcas[i].codigo

        colunaQntdProdutos.innerHTML = qntdProdutos(marcas[i].codigo)
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onclick="selecionarMarca('${i}')"> Selecionar </button>`
    }
}

function qntdProdutos(codigoMarca) {

    let cont = 0;
    for (let produto of produtos) {

        if (produto.codigoMarca == codigoMarca) {
            cont++;
        }
    }
    return cont;
}

function selecionarMarca(index) {

    indiceMarca = index

    document.getElementById("btn-cadastrar-marca").style.display = "none"

    document.getElementById("btn-alterar-marca").style.display = "inline-block"
    document.getElementById("btn-remover-marca").style.display = "inline-block"
    document.getElementById("btn-cancelar-marca").style.display = "inline-block"

    let nome = document.getElementById("txt-nome-marca");
    let codigo = document.getElementById("txt-codigo-marca")


    let marca = marcas[index]

    nome.value = marca.nome
    codigo.value = marca.codigo

}

function alterarMarca() {
    let nome = document.getElementById("txt-nome-marca");
    let alertaMarca = document.getElementById("alerta-marca")

    ocultarAlertaMarca()

    if (nome.value == "") {
        alertaMarca.innerHTML = "Favor preencher o campo nome"
        alertaMarca.classList.add("alert", "alert-danger")
        nome.focus()
    }
    else {

        let marca = new Marca(nome.value)

        let codigo = marcas[indiceMarca].codigo

        marca.codigo = codigo

        marcas[indiceMarca] = marca;
        nome.focus()

        alertaMarca.innerHTML = "Marca alterada"
        alertaMarca.classList.add("alert", "alert-success")
        setTimeout(ocultarAlertaMarca, 2000)
        listarMarcas();
        salvarListaMarcas();
    }


    resetarMarca()
    setTimeout(ocultarAlertaMarca, 2000)

}


function removerMarca() {

    let alertaMarca = document.getElementById("alerta-marca")

    let marca = marcas[indiceMarca]

    if (qntdProdutos(marca.codigo) > 0) {

        alertaMarca.innerHTML = "Marca não pode ser removida"
        alertaMarca.classList.add("alert", "alert-danger")

    } else {

        marcas.splice(indiceMarca, 1)
        alertaMarca.innerHTML = "Marca removido"
        alertaMarca.classList.add("alert", "alert-success")
    }
    setTimeout(ocultarAlertaMarca, 2000)
    resetarMarca()
    listarMarcas()
    salvarListaMarcas()
}

function resetarMarca() {

    document.getElementById("txt-nome-marca").value = "";
    document.getElementById("txt-codigo-marca").value = "";


    document.getElementById("btn-cadastrar-marca").style.display = "inline-block"
    document.getElementById("btn-alterar-marca").style.display = "none"
    document.getElementById("btn-remover-marca").style.display = "none"
    document.getElementById("btn-cancelar-marca").style.display = "none"

}


function resgatarMarcas() {

    if (localStorage.getItem("marcas") != null) {
        marcas = JSON.parse(localStorage.getItem("marcas"))
        listarMarcas();
    }
}