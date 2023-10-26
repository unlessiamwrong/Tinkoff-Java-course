package edu.hw3.Task6;

public class Stock {
    private final String companyName;
    private final int stockPrice;

    public Stock(String companyName, int stockPrice) {
        this.companyName = companyName;
        this.stockPrice = stockPrice;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public String getCompanyName(){
        return companyName;
    }
}
