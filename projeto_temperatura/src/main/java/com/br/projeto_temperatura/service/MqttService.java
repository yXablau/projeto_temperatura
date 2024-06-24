package com.br.projeto_temperatura.service;

import com.br.projeto_temperatura.DAO.InterfaceTemperatura;
import com.br.projeto_temperatura.model.ModelTemperatura;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    @Autowired
    private InterfaceTemperatura interfaceTemperatura;

    private final String broker = "tcp://test.mosquitto.org:1883";
    private final String clientId = "SpringMQTTClient";
    private final String topic = "espdash/automacao/sensor";

    private MqttClient client;

    public MqttService() throws MqttException {
        this.client = new MqttClient(broker, clientId);
        connectAndSubscribe();
    }

    private void connectAndSubscribe() throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);

        this.client.connect(options);
        this.client.subscribe(topic, (topic, message) -> {
            String payload = new String(message.getPayload());
            double temperatureValue = Double.parseDouble(payload);
            long timestamp = System.currentTimeMillis();

            ModelTemperatura temperatura = new ModelTemperatura();
            temperatura.setValor(temperatureValue);
            temperatura.setTimestamp(timestamp);

            interfaceTemperatura.save(temperatura);
        });
    }
}
