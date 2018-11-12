import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class HilightMqttClient extends MqttClient {
	private MqttMessage message;

	public HilightMqttClient(String serverURI, String clientId, MqttClientPersistence persistence)
			throws MqttException {
		super(serverURI, clientId, persistence);

	}

	public void urgentPublish(String topic, String content, int qos) {
		try {
			message = new MqttMessage((content + '1').getBytes());
			message.setQos(qos);
			publish(topic, message);
		} catch (MqttException e) {
			System.out.println("Urgent Publish Error");
			e.printStackTrace();
		}
	}

	public void normalPublish(String topic, String content, int qos) {
		try {
			message = new MqttMessage((content + '0').getBytes());
			message.setQos(qos);
			publish(topic, message);
		} catch (MqttException e) {
			System.out.println("Urgent Publish Error");
			e.printStackTrace();
		}
	}

}
