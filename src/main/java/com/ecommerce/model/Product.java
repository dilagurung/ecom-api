package com.ecommerce.model;

import com.ecommerce.helper.Parent;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sunny KC
 */
@Entity
@Table(name = "product")
@Data
public class Product extends Parent //implements Comparable<Product>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @ManyToOne
    @JoinColumn(name="brand")
    private Brand brand;





    @NotNull
    @Size(min = 2, max = 255)
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(unique = true, name = "sn", nullable = false, length = 20)
    private String serialNumber;

    @NotNull
    @Column(name = "cost_price", precision = 2, nullable = false)
    private Double costPrice;

    @NotNull
    @Column(name = "selling_price", precision = 2, nullable = false)
    private Double sellingPrice;

    @NotNull
    @Column(name = "discount", precision = 2, nullable = false)
    private Double discount;

    @Column(name = "margin", precision = 2)
    private Double margin;

    @NotNull
    @Column(name = "tax", precision = 2, nullable = false)
    private Double tax;


    @NotNull
    @Column(name = "total_price", precision = 2, nullable = false)
    private Double totalPrice;

    @Column(name = "warranty_period")
    private int warrantyPeriod;

    @Temporal(TemporalType.DATE)
    @Column(name = "mfd_on")
    private Date mfdOn;//date of manufacture

    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "image_uri")
    private String imageURI;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "category")
    private Category category;


    @OneToOne(mappedBy = "product")
    private Stock stock;

    @Transient
    protected String categoryName;


    @JsonGetter("category")
    public String getCategoryName() {

        if (category != null) {
                return category.getName();
        }
        return categoryName;
    }

    @JsonSetter("category")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



}


