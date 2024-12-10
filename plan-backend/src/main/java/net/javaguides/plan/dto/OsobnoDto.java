package net.javaguides.plan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OsobnoDto {
    private Long id;
    private String temat;
    private String opis;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataTerminu;
}
