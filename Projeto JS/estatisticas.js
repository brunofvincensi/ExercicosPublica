function listarVendasTotais() {

    let estatisticas = document.getElementById("tabela-estatisticas");



    // Limpar tbody
    estatisticas.innerHTML = "";



    for (let i = 0; i < usuarios.length; i++) {


        let valorTotal = 0;

        for (let venda of vendas) {

            if (venda.codigoUsuario == usuarios[i].codigo) {
                valorTotal += venda.valorTotal
            }
        }

        // Linha da tabela
        var linha = estatisticas.insertRow(i)

        // Colunas
        var colunaNome = linha.insertCell(0)
        var colunaValorTotal = linha.insertCell(1)
        var colunaSelecionar = linha.insertCell(2)


        colunaNome.innerHTML = usuarios[i].nome
        colunaValorTotal.innerHTML = "R$" + valorTotal



        // Enviar dados do JSON

        colunaSelecionar.innerHTML = `<button class="btn btn-success" onclick="selecionarEstatistica('${i}')"> Selecionar </button>`


    }



}

function selecionarEstatistica(index) {


    let vendasUsuario = []



    for (let venda of vendas) {

        if (venda.codigoUsuario == usuarios[index].codigo) {

            vendasUsuario.push(venda)

        }
    }

    let result = "";


    for (let i = 0; i < vendasUsuario.length; i++) {

        result += "Produto: " + vendasUsuario[i].nomeProduto + ", valor total: " + vendasUsuario[i].valorTotal + ", dia: " + vendasUsuario[i].dia + "; \n"

    }

    alert(result)



}



