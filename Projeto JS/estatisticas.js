function listarVendasTotais() {

    let estatisticas = document.getElementById("tabela-estatisticas");

    // Limpar tbody
    estatisticas.innerHTML = "";

    let usuariosSalvos = JSON.parse(localStorage.getItem("usuarios"))

    for (let i = 0; i < usuariosSalvos.length; i++) {

        let valorTotal = 0;

        for (let venda of vendas) {

            if (venda.codigoUsuario == usuariosSalvos[i].codigo) {
                valorTotal += venda.valorTotal
            }
        }

        // Linha da tabela
        var linha = estatisticas.insertRow(i)

        // Colunas
        var colunaNome = linha.insertCell(0)
        var colunaValorTotal = linha.insertCell(1)
        var colunaSelecionar = linha.insertCell(2)


        colunaNome.innerHTML = usuariosSalvos[i].nome
        colunaValorTotal.innerHTML = "R$" + valorTotal

        colunaSelecionar.innerHTML = `<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
         onclick="selecionarEstatistica('${i}')"> Selecionar </button>`
    }
}

function selecionarEstatistica(index) {


    let vendasUsuario = []


    for (let venda of vendas) {

        if (venda.codigoUsuario == usuarios[index].codigo) {

            vendasUsuario.push(venda)

        }
    }

let result = document.getElementById("result")

result.innerHTML = ""


for (let i = 0; i < vendasUsuario.length; i++) {

    result.innerHTML +=  "Produto: " + vendasUsuario[i].nomeProduto + ", valor total: R$" + vendasUsuario[i].valorTotal + ", dia: " + vendasUsuario[i].dia + "</br>"

}

}
