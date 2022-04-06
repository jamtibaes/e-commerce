package br.com.letscode.ecommerce.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    private String nome;
    private ZonedDateTime dataNascimento;

    public UsuarioEntity toEntity() {
        return UsuarioEntity.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .dataCriacao(ZonedDateTime.now())
                .dataAlteracao(ZonedDateTime.now())
                .build();
    }
}
