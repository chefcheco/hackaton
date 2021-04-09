package org.academiadecodigo.rapunshells.converters;

import org.academiadecodigo.rapunshells.command.CarerDto;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarerToCarerDto extends AbstractConverter<Carer, CarerDto> {

    @Override
    public CarerDto convert(Carer carer) {

        CarerDto carerDto = new CarerDto();
        carerDto.setId(carer.getId());
        carerDto.setFirstName(carer.getFirstName());
        carerDto.setLastName(carer.getLastName());
        carerDto.setAge(carer.getAge());
        carerDto.setEmail(carer.getEmail());
        carerDto.setPhone(carer.getPhone());

        return carerDto;
    }
}
