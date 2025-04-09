package ru.MappingLecture;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountInfoMapper {

    BankAccountInfoMapper INSTANCE = Mappers.getMapper(BankAccountInfoMapper.class);

    @Mapping(source = "country", target = "residentOf")
    ShortInfo toShortInfo(ClientBankAccount person);
}
