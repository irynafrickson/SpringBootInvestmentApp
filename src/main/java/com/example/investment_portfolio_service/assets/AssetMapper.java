package com.example.investment_portfolio_service.assets;

import com.example.investment_portfolio_service.assets.dto.AssetDto;
import com.example.investment_portfolio_service.assets.dto.AssetCreateRequest;

public class AssetMapper {

    public static AssetDto toDto(Asset asset) {
        return new AssetDto(
                asset.getId(),
                asset.getName(),
                asset.getType(),
                asset.getStatus(),
                asset.getPurchaseDate(),
                asset.getValue()
        );
    }

    public static Asset fromCreateRequest(AssetCreateRequest req) {
        Asset asset = new Asset();
        asset.setName(req.name());
        asset.setType(req.type());
        asset.setStatus(req.status());
        asset.setPurchaseDate(req.purchaseDate());
        asset.setValue(req.value());
        return asset;
    }
}
