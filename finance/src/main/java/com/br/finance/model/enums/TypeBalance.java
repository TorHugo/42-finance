package com.br.finance.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TypeBalance {

    PAYIN(1L, "Represents that it is a movement of monetary entry."),
    PAYOUT(2L, "Represents that it is a movement of monetary output.");

    private final Long idType;
    private final String descriptionBalance;

    public static TypeBalance parse(final Long idType){
        return Arrays.stream(values()).filter(valeu -> valeu.idType.equals(idType)).findFirst().orElseThrow();
    }
}