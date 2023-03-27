package com.br.finance.model.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseModel {
    private LocalDateTime dateInclusion;
    private LocalDateTime dateUpdate;
}
