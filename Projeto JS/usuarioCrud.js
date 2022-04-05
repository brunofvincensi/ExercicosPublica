
// Armazenar o indice do usuario
var indiceUsuario;

function salvarListaUsuarios(){
    localStorage.setItem("usuarios", JSON.stringify(usuarios))
}


function cadastrarUsuario() {

    let nome = document.getElementById("txt-nome-usuario");
    let login = document.getElementById("txt-login-usuario")
    let senha = document.getElementById("txt-senha-usuario")
    let niveis = document.getElementById("niveis")

    let alertaUsuario = document.getElementById("alerta-usuario")

    alertaUsuario.classList.remove("alert", "alert-danger", "alert-success")

    if (nome.value == "") {
        alertaUsuario.innerHTML = "Favor preencher o campo nome"
        alertaUsuario.classList.add("alert", "alert-danger")
        nome.focus()
    }
    else if (login.value == "") {
        alertaUsuario.innerHTML = "Favor preencher o campo login"
        alertaUsuario.classList.add("alert", "alert-danger")
        login.focus()
    }
    else if (senha.value == "") {
        alertaUsuario.innerHTML = "Favor preencher o campo senha"
        alertaUsuario.classList.add("alert", "alert-danger")
        senha.focus()
    }
    else {

        let usuario = new Usuario(nome.value, login.value, senha.value, niveis.value)

        usuarios.push(usuario);

        alertaUsuario.innerHTML = "Cadastro efetuado"
        alertaUsuario.classList.add("alert", "alert-success")
        setTimeout(ocultarAlertaUsuario, 2000)

        listarUsuarios()
        usuarios.forEach(x => console.log(x))

    }
}

function ocultarAlertaUsuario() {
    var alertaProduto = document.getElementById("alerta-usuario")
    ocultarAlerta(alertaProduto)
}



function listarUsuarios() {

    //Obter o tbody
    var tabela = document.getElementById("tabela-usuario")

    // Limpar tbody
    tabela.innerHTML = "";


    // Laço
    for (let i = 0; i < usuarios.length; i++) {

        // Linha da tabela
        var linha = tabela.insertRow(i)

        // Colunas
        var colunaNome = linha.insertCell(0)
        var colunaLogin = linha.insertCell(1)
        var colunaSenha = linha.insertCell(2)
        var colunaNivel = linha.insertCell(3)
        var colunaSelecionar = linha.insertCell(4)

        // Enviar dados do JSON
        colunaNome.innerHTML = usuarios[i].nome
        colunaLogin.innerHTML = usuarios[i].login
        colunaSenha.innerHTML = usuarios[i].senha
        colunaNivel.innerHTML = usuarios[i].nivel

        colunaSelecionar.innerHTML = `<button class="btn btn-success" onclick="selecionarUsuario('${i}')"> Selecionar </button>`
    }
}

function selecionarUsuario(index) {

    indiceUsuario = index

    document.getElementById("btn-cadastrar-usuario").style.display = "none"

    document.getElementById("btn-alterar-usuario").style.display = "inline-block"
    document.getElementById("btn-remover-usuario").style.display = "inline-block"
    document.getElementById("btn-cancelar-usuario").style.display = "inline-block"

    let nome = document.getElementById("txt-nome-usuario");
    let login = document.getElementById("txt-login-usuario")
    let senha = document.getElementById("txt-senha-usuario")
    let niveis = document.getElementById("niveis")

    indiceUsuario


    let usuario = usuarios[index]

    nome.value = usuario.nome
    login.value = usuario.login
    senha.value = usuario.senha
    niveis.value = usuario.nivel

}


function removerUsuario() {



    usuarios.splice(indiceUsuario, 1)

    listarUsuarios()
    resetarUsuario()
    salvarListaUsuarios()
}

function resetarUsuario() {

    document.getElementById("txt-nome-usuario").value = "";
    document.getElementById("txt-login-usuario").value = "";
    document.getElementById("txt-senha-usuario").value = "";

    document.getElementById("btn-cadastrar-usuario").style.display = "inline-block"
    document.getElementById("btn-alterar-usuario").style.display = "none"
    document.getElementById("btn-remover-usuario").style.display = "none"
    document.getElementById("btn-cancelar-usuario").style.display = "none"

    ocultarAlerta(document.getElementById("alerta-usuario"))

}
