package com.ucc.crudservice.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "El codigo Sku no puede estar vacio")
    private String sku;

   @NotBlank(message = "El name es obligatorio")
    private String name;

    @NotBlank(message = "La descripcion es obligatorio")
    private String description;

   @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value ="0.0", message = "El precio debe ser mayor igual a 0")
    private Double price;

    private Boolean status;
}
