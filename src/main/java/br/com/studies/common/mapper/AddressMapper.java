package br.com.studies.common.mapper;

import br.com.studies.common.domain.AddressAvro;
import br.com.studies.common.domain.AddressModel;
import br.com.studies.controller.dto.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements GenericMapper<PersonDTO.AddressDTO, AddressAvro, AddressModel> {

    @Override
    public AddressAvro dtoToAvro(PersonDTO.AddressDTO dto) {
        return AddressAvro.newBuilder()
                .setCountry(dto.getCountry())
                .setState(dto.getState())
                .setNeighborhood(dto.getNeighborhood())
                .setStreet(dto.getStreet())
                .setNumber(dto.getNumber())
                .setComplement(dto.getComplement())
                .build();
    }

    @Override
    public AddressModel dtoToModel(PersonDTO.AddressDTO dto) {
        return AddressModel.builder()
                .country(dto.getCountry())
                .state(dto.getState())
                .neighborhood(dto.getNeighborhood())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .build();
    }
}
