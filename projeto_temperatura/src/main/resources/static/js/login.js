const formulario = document.querySelector("form");
const Iusuario = document.querySelector(".user");
const Isenha = document.querySelector(".senha");

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    login();
});

function login() {
    fetch("http://localhost:8080/login", {
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
            alert("logado")
            window.location.href = "/home";
        } else {
            alert('Login falhou');
        }
    })
    .catch(function (err) {
        console.log(err);
    });
}
