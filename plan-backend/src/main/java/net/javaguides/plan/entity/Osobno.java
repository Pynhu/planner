package net.javaguides.plan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="plan")
public class Osobno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temat",nullable = false,unique = true)
    private String temat;
    @Column(name = "opis",nullable = false)
    private String opis;

    @Column(name = "data_terminu")
    private LocalDate dataTerminu;

}
