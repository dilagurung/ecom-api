package com.ecommerce.model;

import com.ecommerce.helper.Parent;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
@Table(name = "category")
public class Category extends Parent implements Comparable<Category>,Serializable {
    private static final long serialVersionUID = 6832006422622219737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(unique = true,length = 50, nullable = false)
    private String name;

    @Column(name = "image_uri")
    private String imageURI;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "parentCategory", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Category> childCategories = new HashSet<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CATEGORY_ID", nullable = true)
    private Category parentCategory;



    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @Transient
    protected String parentCategoryName;


    @JsonGetter("parentCategoryName")
    public String getParentCategoryName() {
        if (parentCategory != null) /*||(!parentCategoryName.isEmpty()) )*/
            parentCategoryName = parentCategory.getName();
        return parentCategoryName;

    }

    @JsonSetter("parentCategoryName")
    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    @Override
    public int compareTo(Category category) {
        return this.getName().compareTo(category.getName());
    }
}
