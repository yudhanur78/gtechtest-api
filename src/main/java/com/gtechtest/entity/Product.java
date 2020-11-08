package com.gtechtest.entity;

import com.gtechtest.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "GT_MST_PRODUCT")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCT", nullable = false)
    private int id;

    @Column(name = "PRODUCT")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STORE")
    private String store;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCR")
    private String descr;
}
