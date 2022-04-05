let sections = [
    "main-section",
    "usuario-section",
    "marcas-section",
    "estatisticas-section"
]

let actualSection = sections[0];

function goToUsuarios(){

    document.getElementById(actualSection).style.display = "none"
    
    document.getElementById(sections[1]).style.display = "block"

    actualSection = sections[1];
    
}

function goToMarcas(){

    document.getElementById(actualSection).style.display = "none"
    
    document.getElementById(sections[2]).style.display = "block"
        
    actualSection = sections[2];
    
}


function goToEstatisticas(){

    document.getElementById(actualSection).style.display = "none"
    
    document.getElementById(sections[3]).style.display = "block"
        
    actualSection = sections[3];
    
}



function goToMain(){

    document.getElementById(actualSection).style.display = "none"
    document.getElementById("main-section").style.display = "block"
    actualSection = sections[0];
}


