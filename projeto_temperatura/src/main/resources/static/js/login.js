const formulario = document.querySelector("form");
const Iusuario = document.querySelector(".user");
const Isenha = document.querySelector(".senha");
const mensagemErro = document.querySelector(".error-message"); // Seleciona o elemento de mensagem de erro

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    login();
});

function login() {
    fetch("http://localhost:8090/login", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            usuario: Iusuario.value,
            senha: Isenha.value
        })
    })
    .then(function (res) {
        if (res.ok) {
            alert("Logado com sucesso!");
            window.location.href = "/home"; // Redireciona para a página de home após login bem-sucedido
        } else {
            // Mostra a mensagem de erro
            mensagemErro.textContent = "Não foi possível realizar login. Verifique usuário e senha.";
        }
    })
    .catch(function (err) {
        console.error('Erro ao tentar fazer login:', err);
        // Trate outros erros aqui, se necessário
    });
}
