package br.edu.unifio.setimoprojeto.domain;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome"})
})
@Data
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 50, message = "O tamanho do campo nome deve ser entre 2 e 50")
    private String nome;

    @ManyToOne
    @NotNull(message = "O campo Estado é obrigatorio")
    private Estado estado;


}


