package com.Ecom.Amazon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private boolean productAvailable;
    private Integer stockQuantity;

    private String imageName;
    private String imageType;
    @Lob
    @Column(length = 100000)
    private byte[] imageData;

}
