package br.com.letscode.ecommerce.carrinho;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @GetMapping()
    public ResponseEntity<List<CarrinhoEntity>> listar() {
        return ResponseEntity.ok(carrinhoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoEntity> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.buscar(id));
    }

    @PostMapping()
    public ResponseEntity<CarrinhoEntity> criar(@RequestBody CarrinhoEntity carrinho) {
        return ResponseEntity.ok(carrinhoService.criar(carrinho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoEntity> atualizar(@PathVariable Long id, @RequestBody CarrinhoEntity carrinho) {
        return ResponseEntity.ok(carrinhoService.atualizar(id, carrinho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarrinhoEntity> remover(@PathVariable Long id) {
        carrinhoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}


