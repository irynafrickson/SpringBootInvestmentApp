package com.example.investment_portfolio_service.assets;

import com.example.investment_portfolio_service.assets.dto.AssetDto;
import com.example.investment_portfolio_service.assets.dto.AssetCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public List<AssetDto> getAll() {
        return assetService.findAll();
    }

    @GetMapping("/{id}")
    public AssetDto getOne(@PathVariable Long id) {
        return assetService.findById(id);
    }

    @PostMapping
    public AssetDto create(@RequestBody AssetCreateRequest req) {
        return assetService.create(req);
    }

    @PutMapping("/{id}")
    public AssetDto update(@PathVariable Long id, @RequestBody AssetCreateRequest req) {
        return assetService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assetService.delete(id);
    }
}
