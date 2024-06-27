package com.example.StockTrading3.repository;

import com.example.StockTrading3.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StockRepository {

    private List<Stock> stocks = new ArrayList<>();

    public List<Stock> findAll() {
        return new ArrayList<>(stocks);
    }

    public Optional<Stock> findById(Long id) {
        return stocks.stream().filter(stock -> (stock.getId() == id)).findFirst();
    }

    public Stock save(Stock stock) {
        stocks.add(stock);
        return stock;
    }

    public void delete(Stock stock) {
        stocks.remove(stock);
    }
}
