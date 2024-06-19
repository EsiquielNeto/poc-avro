package br.com.studies.common.mapper;

import br.com.studies.common.domain.GenderEnum;
import br.com.studies.common.domain.PersonAvro;
import br.com.studies.common.domain.PersonModel;
import br.com.studies.common.domain.gender;
import br.com.studies.controller.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper implements GenericMapper<PersonDTO, PersonAvro, PersonModel> {

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;

    @Override
    public PersonAvro dtoToAvro(PersonDTO dto) {

        return PersonAvro.newBuilder()
                .setName(dto.getName())
                .setDocumentNumber(dto.getDocumentNumber())
                .setAge(dto.getAge())
                .setBirthday(dto.getBirthday())
                .setGender(gender.valueOf(dto.getGender()))
                .setProfession(dto.getProfession())
                .setSalary(dto.getSalary())
                .setMarried(dto.isMarried())
                .setAddress(addressMapper.dtoToAvro(dto.getAddresses()))
                .setContacts(contactMapper.dtoToAvroList(dto.getContacts()))
                .build();
    }

    @Override
    public PersonModel dtoToModel(PersonDTO dto) {
        return PersonModel.builder()
                .name(dto.getName())
                .documentNumber(dto.getDocumentNumber())
                .age(dto.getAge())
                .birthday(dto.getBirthday())
                .gender(GenderEnum.getStatus(dto.getGender()))
                .profession(dto.getProfession())
                .salary(dto.getSalary())
                .married(dto.isMarried())
                .address(addressMapper.dtoToModel(dto.getAddresses()))
                .contacts(contactMapper.dtoListToModelList(dto.getContacts()))
                .build();
    }
}
