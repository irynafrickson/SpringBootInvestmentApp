package com.example.investment_portfolio_service.assets.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetDto(
        Long id,
        String name,
        String type,
        String status,
        LocalDate purchaseDate,
        BigDecimal value
) {}
