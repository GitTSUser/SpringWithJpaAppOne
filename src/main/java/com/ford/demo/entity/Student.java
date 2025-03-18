package com.ford.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id //primary key column
    private int id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "s_branch")
    private String branch;
    @Column(name="s_email")
    private String email;
    @Column(name="s_phone")
    private String phone;
}
