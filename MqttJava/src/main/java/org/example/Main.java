package org.example;

import org.eclipse.paho.client.mqttv3.MqttException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MqttException, InterruptedException {

        MqttEnc m = new MqttEnc();
        m.conectar();

        String topic = "espdash/automacao/sensor";
        String msg = "teste";

        //m.publicar(topic, msg);

        m.inscrever(topic);
           
        while(true) {
            Thread.sleep(1000);
        }

        //m.fecharConexao();

    }
}