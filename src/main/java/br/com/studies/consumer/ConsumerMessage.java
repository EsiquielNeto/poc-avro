package br.com.studies.consumer;


import br.com.studies.common.domain.PersonAvro;
import br.com.studies.common.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class ConsumerMessage {

    private static final String TOPIC = "PEOPLE";
    private final PersonMapper personMapper;

    @KafkaListener(topics = TOPIC, groupId = "people_receiver")
    public void listenShopTopic(ConsumerRecord<String, PersonAvro> personAvro) {
        try {
            System.out.println("CHEGOU!");

            log.info("topic: {}", personAvro.topic());
            log.info("headers: {}", personAvro.headers());
            log.info("partition: {}", personAvro.partition());
            log.info("offset: {}", personAvro.offset());
            log.info("Person {}", personAvro);


        } catch (Exception e) {
            log.error("Erro no processamento da mensagem", e);
            throw new RuntimeException("Error consuming message");
        }
    }
}
