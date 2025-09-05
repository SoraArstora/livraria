package br.com.livraria.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private Integer id;
    private String author;
    private String category;
    private String year;
    private String title;
    private String publisher;
    private String edition;
    private String isbn;
    private String pageNumber;
    private String synopsis;
    private String dimensions;
    private String pricingGroup;
    private String barcode;
}
