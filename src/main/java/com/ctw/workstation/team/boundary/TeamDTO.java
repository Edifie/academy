package com.ctw.workstation.team.boundary;

public class TeamDTO {
    private Long id;
    private String name;
    private String product;
    private String defaultLocation;

    public TeamDTO() {
    }

    public TeamDTO(Long id, String name, String product, String defaultLocation) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

}
