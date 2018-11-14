# UrgentClient
UrgentClient using MQTT client(paho)


## Usage

```java
String topic = "MQTT Examples";
String content = "Message from MqttPublishSample";
int qos = 2;
String broker = "tcp://iot.eclipse.org:1883";
String clientId = "JavaSample";
MemoryPersistence persistence = new MemoryPersistence();

try {
	HilightMqttClient sampleClient = new HilightMqttClient(broker, clientId, persistence);
	MqttConnectOptions connOpts = new MqttConnectOptions();
	connOpts.setCleanSession(true);

	System.out.println("Connecting to broker: " + broker);

	sampleClient.connect(connOpts);

	System.out.println("Connected");
	System.out.println("Publishing message: " + content);

	sampleClient.normalPublish(topic, content, qos);// normal message publish
	sampleClient.urgentPublish(topic, content, qos);// urgent message publish
	System.out.println("Message published");

	sampleClient.disconnect();
	System.out.println("Disconnected");
	System.exit(0);
} catch (MqttException me) {
	System.out.println("reason " + me.getReasonCode());
	System.out.println("msg " + me.getMessage());
	System.out.println("loc " + me.getLocalizedMessage());
	System.out.println("cause " + me.getCause());
	System.out.println("excep " + me);
	me.printStackTrace();
}
```
