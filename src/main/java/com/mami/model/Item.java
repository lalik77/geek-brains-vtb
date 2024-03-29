package com.mami.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class    Item {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "price")
    private Double price;

}
