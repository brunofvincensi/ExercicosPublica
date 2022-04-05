var usuarios = []
var marcas = []
var produtos = []


marcas.push(new Marca("Nike", 3))

produtos.push(new Produto("Tenis", 230, 32, 3))

usuarios.push(new Usuario("Bruno", "admin", "admin", niveis[0]))


localStorage.setItem("marcas", JSON.stringify(marcas))