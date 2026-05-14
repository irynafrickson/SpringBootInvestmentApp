package com.example.investment_portfolio_service.assets.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetCreateRequest(
        String name,
        String type,
        String status,
        LocalDate purchaseDate,
        BigDecimal value
) {}
