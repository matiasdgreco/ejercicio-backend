package com.example.ejerciciobe.Utils;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.Status;
import com.example.ejerciciobe.Exception.BadRequestException;

public class CartStatusChecker {

    public static final String INCORRECT_STATUS_REQUIRED = "Incorrect status required";

    public static void statusNew(Cart cart) {
        if (!cart.getStatus().equals(Status.NEW)) {
            throw new BadRequestException(INCORRECT_STATUS_REQUIRED);
        }
    }

    public static void statusReady(Cart cart) {
        if (!cart.getStatus().equals(Status.READY)) {
            throw new BadRequestException(INCORRECT_STATUS_REQUIRED);
        }
    }
}
