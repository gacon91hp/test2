package com.example.test2.model;

import com.example.test2.DTO.RequesProductDTO;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;


@SqlResultSetMappings(
        value = {
                @SqlResultSetMapping(
                        name = "requesProductDTO",
                        classes = @ConstructorResult(
                                targetClass = RequesProductDTO.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "details", type = String.class),
                                        @ColumnResult(name = "category", type = String.class)
                                }
                        )
                )
        }
)

@NamedNativeQuery(
        name = "findType",
        resultSetMapping = "requesProductDTO",
        query = "SELECT p.id,p.name,p.details,c.name AS 'category' FROM product p INNER JOIN category c\n" +
                "ON p.categoryid = c.id\n"+
                "where p.categoryid = ?1"

)

@NamedNativeQuery(
        name = "findAll",
        resultSetMapping = "requesProductDTO",
        query = "SELECT p.id,p.name,p.details,c.name AS 'category' FROM product p INNER JOIN category c\n" +
                "ON p.categoryid = c.id\n"

)

@NamedNativeQuery(
        name = "findId",
        resultSetMapping = "requesProductDTO",
        query = "SELECT p.id,p.name,p.details,c.name AS 'category' FROM product p INNER JOIN category c\n" +
                "ON p.categoryid = c.id\n"+
                "where p.id = ?1"

)

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "details")
    private String details;
    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
