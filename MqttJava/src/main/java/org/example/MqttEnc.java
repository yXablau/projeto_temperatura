package org.example;

import org.eclipse.paho.client.mqttv3.*;

public class MqttEnc {

    String broker;
    String clientId;
    MqttClient client;
    int subQos = 1;
    int pubQos = 1;

    public MqttEnc() {
        this.broker = "tcp://test.mosquitto.org:1883";
        this.clientId = "Pereira";
    }

    public void conectar() throws MqttException {
        this.client = new MqttClient(this.broker, this.clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        this.client.connect(options);
    }

    public void inscrever(String topic) throws MqttException {
        if (this.client.isConnected()) {

            MqttCallback call = new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("connectionLost: " + throwable.getMessage());
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("topic: " + s);
                    System.out.println("qos: " + mqttMessage.getQos());
                    System.out.println("message content: " + new String(mqttMessage.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("deliveryComplete: " + iMqttDeliveryToken.isComplete());
                }
            };

            this.client.setCallback(call);
            this.client.subscribe(topic, this.subQos);

        }
    }

    public void publicar(String topic, String msg) throws MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        message.setQos(this.pubQos);
        this.client.publish(topic, message);
    }

    public void fecharConexao() throws MqttException {
        this.client.disconnect();
        this.client.close();
    }


}