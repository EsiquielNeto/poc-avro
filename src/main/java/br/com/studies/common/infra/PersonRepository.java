package br.com.studies.common.infra;

import br.com.studies.common.domain.PersonModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonModel, String> {
}
