document.addEventListener("DOMContentLoaded", function() {
    var map = L.map('map').setView([-23.55052, -46.633308], 5); // Coordenadas iniciais e zoom

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    fetch("http://localhost:8090/api/sensores")
        .then(response => response.json())
        .then(data => {
            data.forEach(sensor => {
                if (sensor.latitude && sensor.longitude) {
                    var popupContent = `<b>${sensor.nome}</b><br>Latitude: ${sensor.latitude}<br>Longitude: ${sensor.longitude}`;
                    
                    L.marker([sensor.latitude, sensor.longitude])
                        .addTo(map)
                        .bindPopup(popupContent);
                }
            });
        })
        .catch(error => {
            console.error('Erro ao buscar sensores:', error);
        });
});
