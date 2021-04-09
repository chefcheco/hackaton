package org.academiadecodigo.rapunshells.exceptions;

import org.academiadecodigo.rapunshells.errors.ErrorMessage;

public class CarerNotFoundException extends CarerException {

    public CarerNotFoundException() {
        super(ErrorMessage.CARER_NOT_FOUND);
    }
}
