package br.com.zup.Transacao;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import org.apache.kafka.common.serialization.StringDeserializer;

public class TransacoesService{
	
	public static void main(String[] args) {
	
		var consumer = new KafkaConsumer<String, String>(properties());
		consumer.subscribe(Collections.singletonList("transacoes"));
		while(true) {
			var find = consumer.poll(Duration.ofMillis(1000));
			if(!find.isEmpty()) {
				System.out.println("______________________________________________________________");
				System.out.println("Encontrado " + find.count() + " essa quantidade de registros");
			}
			System.out.println("não achou nada");
		}
	}

	private static Properties properties() {
		var properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, TransacoesService.class.getSimpleName());
		return properties;
	}
}
