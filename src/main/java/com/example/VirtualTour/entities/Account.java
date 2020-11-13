package com.example.VirtualTour.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
@JsonPropertyOrder(value = {"id", "username", "password"})
@JsonIgnoreProperties(value = {"date_added", "hibernateLazyInitializer", "handler"})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Valid
    @JsonProperty(value = "username")
    private String username;

    @Valid
    @JsonProperty(value = "password")
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonProperty(value = "date_added")
    private Date date_added;
}
