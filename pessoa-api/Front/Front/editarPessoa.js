function buscarRegistroPorId() {
    const parametros = new URLSearchParams(window.location.search);
    const idPessoa = parametros.get('id');

    const url = `http://localhost:8080/pessoa/${idPessoa}`

    fetch(url)
        .then(response => response.json())
        .then(pessoa => {
            document.querySelector('#id').value = pessoa.id;
            document.querySelector('#nome').value = pessoa.nome;
            document.querySelector('#email').value = pessoa.email;
            document.querySelector('#telefone').value = pessoa.telefone;
            document.querySelector('#endereco').value = pessoa.endereco;
            document.querySelector('#ativo').checked = pessoa.ativo;
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}

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
    window.location.href = './main.html';
}

const form = document.querySelector('#formulario');

form.addEventListener('submit', function (e) {
    e.preventDefault(); 

    const bodyJson = bodyJsonPessoa();

    const idPessoa = document.querySelector("#id").value;
    const url = `http://localhost:8080/pessoa/${idPessoa}`

    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: bodyJson
    })
        .then(function (response) {
            if (response.ok) {
                alert("Dados atualizados com sucesso!");
                redirecionarListagem();
            } else
                alert("Erro ao atualizar o registro");
        })
        .catch(function (error) {
            console.error(error);
        });
});

buscarRegistroPorId();