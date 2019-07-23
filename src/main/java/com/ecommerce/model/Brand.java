package com.ecommerce.model;

import com.ecommerce.helper.Parent;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by oa on 6/18/2019.
 */
@Entity
@Data
public class Brand extends Parent
{

    @Id
    @GeneratedValue
    private  Long id;
    private String name;


    @OneToMany(mappedBy = "brand")
    private List<Product> productList;




}
