package br.com.rufuziu.ms_register_and_auth.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student extends User{
}
