package com.app.server.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class NumericRequest {

    BigDecimal[] data;
}
