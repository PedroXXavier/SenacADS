function bodyJsonPessoa() {
    const nome = document.querySelector('#nome').value;
    const email = document.querySelector('#email').value;
    const telefone = document.querySelector('#telefone').value;
    const endereco = document.querySelector('#endereco').value;
    const ativo = document.querySelector('#ativo').checked;

    const pessoa = {
        nome: nome,
        email: email,
        telefone: telefone,
        endereco: endereco,
        ativo: ativo
    };

    const json = JSON.stringify(pessoa);
    return json;
}

function redirecionarListagem(){
    window.location.href = "./main.html";
}

const form = document.querySelector("#formulario");

form.addEventListener("submit", function (e) {
    e.preventDefault(); 

    const bodyJson = bodyJsonPessoa();

    const url = `http://localhost:8080/pessoa`;

    fetch(url, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: bodyJson
    })
        .then(function (response) {
            if (response.ok) {
                alert("Dados registrados com sucesso!");
                redirecionarListagem();
            } else
                alert("Erro ao enviar o formulário");
        })
        .catch(function (error) {
            console.error(error);
        });
});