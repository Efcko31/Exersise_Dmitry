package ru.StreamApi.Exersises;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface Ex7Mapper {
    Ex7Mapper INSTACE = Mappers.getMapper(Ex7Mapper.class);

    DTOForEx7 toDTOForEx7(StudentsForEx7 studentsForEx7,
                          double averageScore);
}
