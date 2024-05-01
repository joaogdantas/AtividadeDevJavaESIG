package com.esig.joaogdantas.model.vencimentos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum TipoVencimento {
    @Enumerated(EnumType.STRING)
	CREDITO,
    @Enumerated(EnumType.STRING)
    DEBITO
}
