package org.academiadecodigo.rapunshells.services;

import org.academiadecodigo.rapunshells.exceptions.*;
import org.academiadecodigo.rapunshells.persistence.dao.CarerDao;
import org.academiadecodigo.rapunshells.persistence.model.AbstractModel;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarerServiceImpl implements CarerService {

    private CarerDao carerDao;

    @Autowired
    public void setCarerDao(CarerDao carerDao) {
        this.carerDao = carerDao;
    }

    @Override
    public Carer get(Integer id) {
        return carerDao.findById(id);
    }

    @Transactional
    @Override
    public Carer save(Carer carer) {
        return carerDao.saveOrUpdate(carer);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws CarerNotFoundException, AssociationExistsException {

        Carer carer = Optional.ofNullable(carerDao.findById(id))
                .orElseThrow(CarerNotFoundException::new);

        carerDao.delete(id);
    }

    @Override
    public List<Carer> list() {
        return carerDao.findAll();
    }


}

