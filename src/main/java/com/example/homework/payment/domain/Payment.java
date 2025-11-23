package com.example.homework.payment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "\"payment\"", schema = "public")
public class Payment {

    @Id
    private UUID id;

}
