package com.ecommerce.model;

import com.ecommerce.helper.Parent;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Sunny KC
 */
@Entity
@Data
@Table(name = "stock")
public class Stock extends Parent implements Serializable{

    private static final long serialVersionUID = 6832006422622219737L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(nullable = false)
    private int quantity;

    @NotNull
    @Column(name = "reorder_level", nullable = false)
    private int reorderLevel;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="product")
    private Product product;

    @Transient
    protected String productName;




    @JsonGetter("product")
    public String getProductName() {
        if (product != null)
            productName = product.getName();
        return productName;
    }

    @JsonSetter("product")
    public void setProductName(String productName) {

        this.productName = productName;
    }

}
