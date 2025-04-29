function preencherTabela(registros){
    const tabela = document.querySelector('#tabelaRegistros tbody')
 
    registros.forEach(registro => {
        const row = tabela.insertRow();
        row.dataset.id = registro.id;

        const idCell = row.insertCell();
        idCell.textContent = registro.id;

        const nomeCell = row.insertCell();
        nomeCell.textContent = registro.nome;
 
        const emailCell = row.insertCell();
        emailCell.textContent = registro.email;
 
        const telefoneCell = row.insertCell();
        telefoneCell.textContent = registro.telefone;
 
        const enderecoCell = row.insertCell();
        enderecoCell.textContent = registro.endereco;
 
        const ativoCell = row.insertCell();
        
        if(registro.ativo)
            ativoCell.textContent = "Sim"
        else
            ativoCell.textContent = "Não"
      
        const acoesCell = row.insertCell();
        acoesCell.classList.add('text-center');
 
        const editButton = document.createElement('button');
        editButton.textContent = 'Editar';

        editButton.classList.add('btn');
        editButton.classList.add('btn-outline-dark');
        editButton.classList.add('me-2');

        editButton.addEventListener('click', () => redirecionarEdicao(registro.id));
        acoesCell.appendChild(editButton);
       
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Excluir';

        deleteButton.classList.add('btn');
        deleteButton.classList.add('btn-outline-danger');
        
        deleteButton.addEventListener('click', () => excluirRegistro(registro.id));
        acoesCell.appendChild(deleteButton);
    });   
}

function redirecionarEdicao(id) {
    window.location.href = "./editarPessoa.html?id="+id;
}
 
function excluirRegistro(id){
    const confirmacao = confirm("Deseja remover este registro?");

    if (confirmacao) { 
        const url = `http://localhost:8080/pessoa/${id}`
 
            fetch(url, {
                method: 'DELETE'
            })
            .then(response => {
                if (response.ok) {
                    alert("Registro excluído com sucesso!")
 
                    const tabela = document.querySelector('#tabelaRegistros');
                    const linha = tabela.querySelector(`tr[data-id="${id}"]`);
                    linha.remove();
                } else
                    console.error("Erro ao excluir o registro");
            })
            .catch(error => {
                console.error('Erro:', error);
            });
    }
}
 
function buscarRegistros(){
    const url = `http://localhost:8080/pessoa`
    fetch(url)
        .then(response => response.json())
        .then(data => {
            preencherTabela(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
} 

buscarRegistros();