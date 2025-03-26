package com.nathannolacio.apifaturas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "fatura")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar vazio!")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve possuir 16 dígitos!")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar vazio!")
    @Size(min = 3, max = 100, message = "O nome do titular deve possuir entre 3 e 10 caracteres!")
    private String titular;

    @NotNull(message = "O valor não pode ser nulo")
    @DecimalMin(value = "10.00", message = "O valor mínimo é R$10,00!")
    @DecimalMax(value = "5000.00", message = "O valor máximo é R$5000,00!")
    private Double valor;

    @NotNull(message = "A data de pagamento não pode ser nula!")
    @FutureOrPresent(message = "A data de pagamento deve ser a data atual ou uma data futura!")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar vazio!")
    @Email(message = "O email deve ser válido!")
    private String emailContato;
}
