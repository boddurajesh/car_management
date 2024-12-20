package com.car.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data

public class Car {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name is required")
    private String name;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Year is required")
    @Min(value = 1886, message = "Year must be no earlier than 1886")
    @Max(value = 2100, message = "Year must be realistic")
    private Integer year;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;
	

}
