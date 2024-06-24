const clientId = "Pereira";
const host = "test.mosquitto.org";
const port = 1883; 
const topic = "espdash/automacao/sensor";

const client = new Paho.MQTT.Client(host, port, clientId);

const options = {
    timeout: 3,
    onSuccess: function () {
        console.log("Conectado ao MQTT");
        client.subscribe(topic, { qos: 1 });
    },
    onFailure: function (message) {
        console.error("Falha ao conectar: " + message.errorMessage);
    }
};

client.onConnectionLost = function (responseObject) {
    if (responseObject.errorCode !== 0) {
        console.error("Conexão perdida: " + responseObject.errorMessage);
    }
};

client.onMessageArrived = function (message) {
    console.log("Mensagem recebida: " + message.payloadString);
    document.getElementById("temperatura-valor").innerText = message.payloadString;
};

function conectar() {
    client.connect(options);
}

function inscrever(topic) {
    if (client.isConnected()) {
        client.subscribe(topic, { qos: 1 });
    }
}

function publicar(topic, msg) {
    const message = new Paho.MQTT.Message(msg);
    message.qos = 1;
    client.send(topic, message);
}

function fecharConexao() {
    if (client.isConnected()) {
        client.disconnect();
    }
}
