package br.com.studies.common.mapper;

import java.util.Collection;
import java.util.List;

public interface GenericMapper<D, A, M> {

    default List<A> dtoToAvroList(Collection<D> dto) {
        return dto.stream()
                .map(this::dtoToAvro)
                .toList();
    }

    default List<M> dtoListToModelList(Collection<D> dtoList) {
        return dtoList.stream()
                .map(this::dtoToModel)
                .toList();
    }

    A dtoToAvro(D dto);

    M dtoToModel(D dto);
}
