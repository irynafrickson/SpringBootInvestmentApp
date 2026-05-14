package com.example.investment_portfolio_service.assets; // use your actual package

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
