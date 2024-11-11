package com.factoriaf5.model;

public class Computer {
    private Long id;
    private String brand;
    private int memory;
    private String processor;
    private String operatingSystem;
    private double price;

    public Computer(Long id, String brand, int memory, String processor, String operatingSystem, double price) {
        this.id = id;
        this.brand = brand;
        this.memory = memory;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public Computer() {
        this.id = 0L;
    }

    public long getId() {
        if (this.id == null) {
            throw new IllegalStateException("ID no está inicializado");
        }
        return this.id.longValue();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String showDetails() {
        return "Brand: " + brand + ", Processor: " + processor + ", Memory: " + memory + "GB, OS: " + operatingSystem + ", Price: " + price;
    }
}