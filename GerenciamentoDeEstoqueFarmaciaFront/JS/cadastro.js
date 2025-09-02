document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");
    
    form.addEventListener("submit", function(e) {
        e.preventDefault(); //Ecita que a página recarregue

        //Pega os valores dos formulário
        const usuario = document.getElementById("usuario").value;
        const email = document.getElementById("email").value;
        const senha = Document.getElementById("senha").value;

        //Monta o objeto para envio
        const cadastroData = {
            usuario: usuario,
            email: email,
            senha: senha
        };

        //Enviando os dados para o backend
        fetch("http://localhost:8080/cadastro", {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(cadastroData)
        }) 
        .then(response => response.json())
        .then(data => {
            console.log("Usuário cadastrado!", data);
            alert("Cadastro realizado com sucesso");
            form.reset(); //Limpa o formulário
        })
        .catch(error => {
            console.error("Erro ao cadastrar usuário:", error);
            alert("Erro ao cadastrar o usuário");
        });
    });
});