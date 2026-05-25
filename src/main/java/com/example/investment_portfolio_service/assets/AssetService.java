package com.example.investment_portfolio_service.assets;

import com.example.investment_portfolio_service.assets.dto.AssetDto;
import com.example.investment_portfolio_service.assets.dto.AssetCreateRequest;
import com.example.investment_portfolio_service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(AssetMapper::toDto)
                .toList();
    }

    public AssetDto findById(Long id) {
        return assetRepository.findById(id)
                .map(AssetMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
    }

    public AssetDto create(AssetCreateRequest req) {
        Asset asset = AssetMapper.fromCreateRequest(req);
        Asset saved = assetRepository.save(asset);
        return AssetMapper.toDto(saved);
    }

    public AssetDto update(Long id, AssetCreateRequest req) {
        Asset existing = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        existing.setName(req.name());
        existing.setType(req.type());
        existing.setStatus(req.status());
        existing.setPurchaseDate(req.purchaseDate());
        existing.setValue(req.value());

        Asset updated = assetRepository.save(existing);
        return AssetMapper.toDto(updated);
    }

    public void delete(Long id) {
        assetRepository.deleteById(id);
    }
}
