package org.academiadecodigo.rapunshells.converters;

import org.academiadecodigo.rapunshells.command.CarerDto;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.academiadecodigo.rapunshells.services.CarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarerDtoToCarer implements Converter<CarerDto, Carer> {

    private CarerService carerService;

    @Autowired
    public void setCarerService(CarerService carerService) {
        this.carerService = carerService;
    }

    @Override
    public Carer convert(CarerDto carerDto) {

        Carer carer = (carerDto.getId() != null ? carerService.get(carerDto.getId()) : new Carer());

        carer.setFirstName(carerDto.getFirstName());
        carer.setLastName(carerDto.getLastName());
        carer.setAge(carerDto.getAge());
        carer.setEmail(carerDto.getEmail());
        carer.setPhone(carerDto.getPhone());
        carer.setRating(carerDto.getRating());
        carer.setServiceCounter(carerDto.getServiceCounter());

        return carer;
    }
}
