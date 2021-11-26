package br.edu.unifio.setimoprojeto.domain;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome"})
})
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 50, message = "O tamanho do campo nome deve ser entre 3 e 50")
    private String nome;

    @NotNull(message = "O campo preço e obrigatorio")
    @DecimalMin(value = "0.01",message ="O valor minimo desse campo preço é de R$ 0,01" )
    @DecimalMax(value = "1000",message ="O valor maximo para o campo preço é de R$ 1000")
    private Double preco;

    @NotNull(message = "O campo quantidade e obrigatorio")
    @Min(value = 0,message = "O valor minimo para o campo quantidade e zero")
    @Max(value = 10, message = "O valor maximo para o campo quantidade e 10")
    private Integer quantidade;

    @NotNull(message = "O campo validade e obrigatorio")
    @FutureOrPresent(message = "A data informada no campo validade deve ser uma data presente ou futura ")
    private LocalDate validade;

    @ManyToOne
    @NotNull(message = "O campo categoria é obrigatorio")
    private Categoria categoria;

}
