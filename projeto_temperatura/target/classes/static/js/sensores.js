const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Ilatitude = document.querySelector(".latitude");
const Ilongitude = document.querySelector(".longitude");

formulario.addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário
    
    cadastrar(); // Chama a função para enviar os dados
    limpar(); // Limpa os campos após o envio
});

function cadastrar() {
    // Validar se os campos estão preenchidos
    if (!Inome.value || !Ilatitude.value || !Ilongitude.value) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    // Validar se latitude e longitude são números
    const latitude = parseFloat(Ilatitude.value);
    const longitude = parseFloat(Ilongitude.value);

    if (isNaN(latitude) || isNaN(longitude)) {
        alert("Latitude e longitude devem ser números válidos.");
        return;
    }

    // Validar intervalos para latitude
    if (latitude < -90 || latitude > 90) {
        alert("Latitude deve estar entre -90 e 90 graus.");
        return;
    }

    // Validar intervalos para longitude
    if (longitude < -180 || longitude > 180) {
        alert("Longitude deve estar entre -180 e 180 graus.");
        return;
    }

    // Se passar nas validações, enviar a requisição POST
    fetch("http://localhost:8090/api/sensores", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            latitude: latitude,
            longitude: longitude
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
