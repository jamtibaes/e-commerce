package br.com.letscode.ecommerce.usuario;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private ZonedDateTime dataNascimento;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAlteracao;

}
