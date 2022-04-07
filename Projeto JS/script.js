// Armazenar o usuario logado
let usuarioAtual;


function validaLogin() {

    console.log("ola")

    let login = document.getElementById("txt-login")
    let senha = document.getElementById("txt-senha")
    var alerta = document.getElementById("alerta")
    ocultarAlerta(alerta);
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

                var usuarioLogado = usuario;


                existe = true;
                break;

            }
        }

        if (existe) {

            usuarioAtual = usuarioLogado;

            if(usuarioLogado.nivel == 2){
           
                let marcas = document.getElementById("go-to-marcas")
                marcas.classList += " disabled"

                let niveis = document.getElementById("niveis")
                niveis.innerHTML = `<option value="3">Vendedor</option>`
                usuarios = usuarios.filter(u => u.nivel == 3)
                listarUsuarios()
                
            }else if(usuarioLogado.nivel == 3){
                let marcas = document.getElementById("go-to-marcas")
                marcas.classList += " disabled" 
                
                let usuarios = document.getElementById("go-to-usuarios")
                usuarios.classList += " disabled"


                let btnsSelecionar = document.getElementsByClassName("btn-produto-selecionar")

                for(let s of btnsSelecionar){
                    s.style.display = "none"
                }

                let cadastrar = document.getElementById("form-produto")
                cadastrar.style.display = "none"
      
            }

            goToMain()

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

function ocultarAlerta(alerta) {

    alerta.classList.remove("alert", "alert-danger", "alert-success")
    alerta.innerHTML = "";
}

window.onload = () => {

   // usuarios.push(new Usuario("Bruno", "admin", "admin", 1))
   // salvarListaUsuarios()

    resgatarProdutos()
    resgatarUsuarios()
    resgatarMarcas()
    resgatarVendas()
}
