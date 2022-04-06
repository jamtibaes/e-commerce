package br.com.letscode.ecommerce.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<UsuarioEntity>> listar() {
        List<UsuarioEntity> usuarios = usuarioService.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscar(@PathVariable Long id) {
        UsuarioEntity usuario = usuarioService.buscar(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping()
    public ResponseEntity<UsuarioEntity> salvar(@RequestBody UsuarioRequest usuario) {
        UsuarioEntity usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.created(null).body(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest usuario) {
        UsuarioEntity usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}

