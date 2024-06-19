package br.com.studies.common.domain.service;

import br.com.studies.common.config.ProducerMessage;
import br.com.studies.common.domain.PersonModel;
import br.com.studies.common.infra.PersonRepository;
import br.com.studies.common.mapper.PersonMapper;
import br.com.studies.controller.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ProducerMessage producerMessage;
    private final PersonMapper personMapper;

    public List<PersonModel> list() {
        return personRepository.findAll();
    }

    public PersonModel findById(String personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public PersonModel save(PersonDTO personDTO) {
        try {
            var person = personMapper.dtoToModel(personDTO);
            var personSaved = personRepository.save(person);

            var personAvro = personMapper.dtoToAvro(personDTO);
            producerMessage.sendMessage(personAvro);
            log.info("send person with sucessfully for {}", personAvro.getName());

            return personSaved;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String personId) {
        personRepository.findById(personId)
                .ifPresentOrElse(
                        person -> personRepository.deleteById(person.getId()),
                        () -> {
                            throw new RuntimeException(String.format("person not found with %s", personId));
                        }
                );
    }
}
