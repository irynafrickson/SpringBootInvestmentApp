package com.example.investment_portfolio_service.assets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetCreateRequest(
        @NotBlank String name,
        @NotBlank String type,
        @NotBlank String status,
        @NotNull @PastOrPresent LocalDate purchaseDate,
        @NotNull @Positive BigDecimal value
) {}
