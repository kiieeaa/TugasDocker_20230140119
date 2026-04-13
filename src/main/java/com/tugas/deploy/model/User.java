package com.tugas.deploy.model;

import lombok.Data;

@Data // Anotasi Lombok untuk generate getter, setter, dll [cite: 27]
public class User {
    private String nama;
    private String nim;
    private String jenisKelamin;
}