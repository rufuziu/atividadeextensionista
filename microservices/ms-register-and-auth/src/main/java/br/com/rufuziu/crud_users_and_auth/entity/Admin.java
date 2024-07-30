package br.com.rufuziu.crud_users_and_auth.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin extends User{
}
