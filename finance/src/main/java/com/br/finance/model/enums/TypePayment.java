package com.br.finance.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TypePayment {

    CREDIT_CARD     (1L, "Payment type credit card."),
    DEBIT_CARD      (2L, "Payment type debit card."),
    BANK_TICKET     (3L, "Payment type bank ticket."),
    PIX             (4L, "Payment type pix."),
    BANK_TRANSFER   (5L, "Payment type bank transfer.");

    private final Long idPayments;
    private final String descriptionPayment;

    public static TypePayment parse(final Long idType){
        return Arrays.stream(values())
                .filter(valeu -> valeu.idPayments.equals(idType)).findFirst().orElseThrow();
    }
}
