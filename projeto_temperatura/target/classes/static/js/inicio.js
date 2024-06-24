// inicio.js
document.addEventListener('DOMContentLoaded', function () {
    var map = L.map('map').setView([-23.55052, -46.633308], 13); // Coordenadas de São Paulo, ajuste conforme necessário

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Exemplo de coordenadas obtidas do banco de dados
    var coordenadas = [
        { lat: -23.55052, lng: -46.633308, descricao: "Local 1" },
        { lat: -23.559616, lng: -46.658356, descricao: "Local 2" }
    ];

    coordenadas.forEach(function (ponto) {
        L.marker([ponto.lat, ponto.lng]).addTo(map)
            .bindPopup(ponto.descricao);
    });


});
