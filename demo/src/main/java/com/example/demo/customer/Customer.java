package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    private Long id;

    @NotBlank(message = "Name Cannot Be Empty")
    private String name;

    @NotBlank(message = "Password Cannot Be Empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "Email Cannot Be Empty")
    @Email(message = "Please Enter Valid Email")
    private String email;

    public Long getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    @JsonIgnore
    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

}
