package br.com.rufuziu.ms_register_and_auth.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers")
public class Teacher extends User{
}
