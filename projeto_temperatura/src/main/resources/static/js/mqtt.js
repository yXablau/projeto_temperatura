const clientId = "mqttjs_" + Math.random().toString(16).substr(2, 8);
const host = "ws://test.mosquitto.org:8080/mqtt";
const options = {
    timeout: 3,
    onSuccess: function () {
        console.log("Conectado ao MQTT");
        client.subscribe("espdash/automacao/sensor", { qos: 1 });
    },
    onFailure: function (message) {
        console.error("Falha ao conectar: " + message.errorMessage);
    }
};

const client = new Paho.MQTT.Client(host, clientId);

client.onConnectionLost = function (responseObject) {
    if (responseObject.errorCode !== 0) {
        console.error("Conexão perdida: " + responseObject.errorMessage);
    }
};

client.onMessageArrived = function (message) {
    console.log("Mensagem recebida: " + message.payloadString);
    document.getElementById("temperatura-valor").innerText = message.payloadString + " °C";
};

client.connect(options);
