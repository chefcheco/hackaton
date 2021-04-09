package org.academiadecodigo.rapunshells.controller.rest;

import org.academiadecodigo.rapunshells.command.CarerDto;
import org.academiadecodigo.rapunshells.converters.CarerDtoToCarer;
import org.academiadecodigo.rapunshells.converters.CarerToCarerDto;
import org.academiadecodigo.rapunshells.exceptions.AssociationExistsException;
import org.academiadecodigo.rapunshells.exceptions.CarerNotFoundException;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.academiadecodigo.rapunshells.services.CarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/carer")
public class RestCarerController {

    private CarerService carerService;
    private CarerDtoToCarer carerDtoToCarer;
    private CarerToCarerDto carerToCarerDto;

    @Autowired
    public void setCarerService(CarerService carerService) {
        this.carerService = carerService;
    }

    @Autowired
    public void setCarerDtoToCarer(CarerDtoToCarer carerDtoToCarer) {
        this.carerDtoToCarer = carerDtoToCarer;
    }

    @Autowired
    public void setCarerToCarerDto(CarerToCarerDto carerToCarerDto) {
        this.carerToCarerDto = carerToCarerDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<CarerDto>> listCarers() {

        List<CarerDto> carerDtos = carerService.list().stream()
                .map(carer -> carerToCarerDto.convert(carer))
                .collect(Collectors.toList());

        return new ResponseEntity<>(carerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CarerDto> showCarer(@PathVariable Integer id) {

        Carer carer = carerService.get(id);

        if (carer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(carerToCarerDto.convert(carer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCarer(@Valid @RequestBody CarerDto carerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || carerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Carer savedCarer = carerService.save(carerDtoToCarer.convert(carerDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/carer/" + savedCarer.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<CarerDto> editCarer(@Valid @RequestBody CarerDto carerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (carerDto.getId() != null && !carerDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (carerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        carerDto.setId(id);

        carerService.save(carerDtoToCarer.convert(carerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<CarerDto> deleteCarer(@PathVariable Integer id) {

        try {

            carerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (AssociationExistsException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (CarerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
