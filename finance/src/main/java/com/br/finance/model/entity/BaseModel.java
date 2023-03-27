package com.br.finance.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseModel {
    private LocalDateTime dateInclusion;
    private LocalDateTime dateUpdate;
}
