package br.com.studies.common.mapper;

import br.com.studies.common.domain.ContactAvro;
import br.com.studies.common.domain.ContactModel;
import br.com.studies.controller.dto.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements GenericMapper<PersonDTO.ContactDTO, ContactAvro, ContactModel> {
    @Override
    public ContactAvro dtoToAvro(PersonDTO.ContactDTO dto) {
        return ContactAvro.newBuilder()
                .setEmail(dto.getEmail())
                .setPhone(dto.getPhone())
                .build();
    }

    @Override
    public ContactModel dtoToModel(PersonDTO.ContactDTO dto) {
        return ContactModel.builder()
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }
}
