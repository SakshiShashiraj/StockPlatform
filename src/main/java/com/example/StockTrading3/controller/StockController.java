package com.example.StockTrading3.controller;

import com.example.StockTrading3.model.Stock;
import com.example.StockTrading3.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));

        stock.setName(stockDetails.getName());
        stock.setPrice(stockDetails.getPrice());
        stock.setQuantity(stockDetails.getQuantity());

        return stockRepository.save(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        stockRepository.delete(stock);
    }
}
