package br.com.studies.common.config;

import br.com.studies.common.domain.PersonAvro;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProducerMessage {

    private final static String TOPIC = "PEOPLE";
    private final KafkaTemplate<String, PersonAvro> producer;

    public void sendMessage(PersonAvro personAvro) {
        ProducerRecord<String, PersonAvro> record = new ProducerRecord<>(TOPIC, personAvro);
        producer.send(record);
    }
}
