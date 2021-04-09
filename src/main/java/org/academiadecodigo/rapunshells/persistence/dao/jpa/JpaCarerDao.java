package org.academiadecodigo.rapunshells.persistence.dao.jpa;

import org.academiadecodigo.rapunshells.persistence.dao.CarerDao;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCarerDao extends GenericJpaDao<Carer> implements CarerDao {

    public JpaCarerDao() {
        super(Carer.class);
    }
}
