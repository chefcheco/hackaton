package org.academiadecodigo.rapunshells.services.mock;

import org.academiadecodigo.rapunshells.exceptions.AssociationExistsException;
import org.academiadecodigo.rapunshells.exceptions.CarerNotFoundException;
import org.academiadecodigo.rapunshells.persistence.model.AbstractModel;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.academiadecodigo.rapunshells.services.CarerService;

import java.util.*;
import java.util.stream.Collectors;

public class MockCarerService extends AbstractMockService<Carer> implements CarerService {

    @Override
    public Carer get(Integer id) {
        return modelMap.get(id);
    }

    @Override
    public Carer save(Carer carer) {

        if (carer.getId() == null) {
            carer.setId(getNextId());
        }

        modelMap.put(carer.getId(), carer);
        return carer;
    }

    @Override
    public void delete(Integer id) throws AssociationExistsException {

        Carer carer = get(id);

        modelMap.remove(id);
    }

    @Override
    public List<Carer> list() {
        return new ArrayList<>(modelMap.values());
    }
}
