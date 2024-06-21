const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Ilatitude = document.querySelector(".latitude");
const Ilongitude = document.querySelector(".longitude");

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    cadastrar();
    limpar();
});

function cadastrar() {
    fetch("http://localhost:8080/api/sensores", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
                nome: Inome.value,
                latitude: Ilatitude.value,
                longitude: Ilongitude.value
        })
    })
    .then(function (res) {
        if (res.ok) {
            return res.json();
        } else {
            throw new Error('Erro ao cadastrar sensor');
        }
    })
    .then(function (data) {
        console.log(data);
        alert("Sensor cadastrado com sucesso");
    })
    .catch(function (err) {
        console.log(err);
        alert("Falha ao cadastrar sensor: " + err.message);
    });
}

function limpar() {
    Inome.value = "";
    Ilatitude.value = "";
    Ilongitude.value = "";
}
