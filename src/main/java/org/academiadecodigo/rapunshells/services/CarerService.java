package org.academiadecodigo.rapunshells.services;

import org.academiadecodigo.rapunshells.exceptions.*;
import org.academiadecodigo.rapunshells.persistence.model.Carer;

import java.util.List;

public interface CarerService {

    Carer get(Integer id);

    Carer save(Carer carer);

    void delete(Integer id) throws AssociationExistsException, CarerNotFoundException;

    List<Carer> list();

}
