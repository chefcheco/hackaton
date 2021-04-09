package org.academiadecodigo.rapunshells.exceptions;

import org.academiadecodigo.rapunshells.errors.ErrorMessage;

public class AssociationExistsException extends CarerException {

    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}
