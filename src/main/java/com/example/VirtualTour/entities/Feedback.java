package com.example.VirtualTour.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="feedbacks")
@JsonPropertyOrder(value = {"id", "name", "contact_no", "email", "province", "queries"})
@JsonIgnoreProperties(value = {"data_added", "hibernateLazyInitializer", "handler"})
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "contact_no")
    private String contactNo;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "province")
    private String province;

    @JsonProperty(value = "query")
    private String query;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonProperty(value = "date_added")
    private Date date_added;
}
