package br.com.letscode.ecommerce.usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> listar() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscar(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioEntity salvar(UsuarioRequest usuario) {
        return usuarioRepository.save(usuario.toEntity());
    }

    public UsuarioEntity atualizar(Long id ,UsuarioRequest usuario) {
        UsuarioEntity usuarioEntity = buscar(id);
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setDataNascimento(usuario.getDataNascimento());
        usuarioEntity.setDataAlteracao(ZonedDateTime.now());
        return usuarioRepository.save(usuarioEntity);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
