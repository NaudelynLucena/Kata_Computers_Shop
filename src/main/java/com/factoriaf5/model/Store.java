package com.factoriaf5.model;

import java.util.ArrayList;

public class Store {
    private Long id;
    private String name;
    private String owner;
    private String taxId;
    private ArrayList<Computer> computers;

    // Constructor
    public Store(Long id, String name, String owner, String taxId) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.taxId = taxId;
        this.computers = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public boolean deleteComputer(String brand) {
        return computers.removeIf(computer -> computer.getBrand().equals(brand));
    }

    public Computer findComputer(String brand) {
        for (Computer computer : computers) {
            if (computer.getBrand().equals(brand)) {
                return computer;
            }
        }
        return null;
    }

    public ArrayList<Computer> listComputers() {
        return new ArrayList<>(computers);
    }
}