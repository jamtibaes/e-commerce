package br.com.letscode.ecommerce.produto;

import br.com.letscode.ecommerce.produto.models.ProdutoEntity;
import br.com.letscode.ecommerce.produto.models.ProdutoFiltros;
import br.com.letscode.ecommerce.produto.models.ProdutoRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@AllArgsConstructor
@RequestMapping("produtos")
@RestController
public class ProdutoController {

    private ProdutoService produtoService;

    // LISTAR
    @GetMapping()
    public ResponseEntity<Page<ProdutoEntity>> get(
            @RequestParam(name = "offset") Integer offset,
            @RequestParam(name = "limit") Integer limit,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "valor_maximo", required = false) BigDecimal valorMaximo
    ) {
        ProdutoFiltros filtros = new ProdutoFiltros();
        filtros.setNome(nome);
        filtros.setValor(valorMaximo);

        Page<ProdutoEntity> produtos = produtoService.buscarTodos(offset, limit, filtros);
        return ResponseEntity.ok(produtos);
    }

    // CADASTRAR
    //    @Secured("USER")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProdutoEntity> create(
            @RequestBody ProdutoRequest request
    ) {
        ProdutoEntity produto = produtoService.criar(request);
        return ResponseEntity.created(null).body(produto);
    }

    // CONSULTAR
    @GetMapping("/codigo/{codigoBarra}")
    public ResponseEntity<ProdutoEntity> getByCodigoBarra(
            @PathVariable(name = "codigoBarra") String codigoBarra) {
        ProdutoEntity produto = produtoService.buscarPorCodigoBarra(codigoBarra);
        return ResponseEntity.ok(produto);
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getById(
            @PathVariable(name = "id") Long id) {
        ProdutoEntity produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    // REMOVER
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProdutoEntity> delete(
            @PathVariable(name = "id") Long id) {
        ProdutoEntity produto = produtoService.remover(id);
        return ResponseEntity.ok(produto);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProdutoEntity> update(
            @PathVariable(name = "id") Long id,
            @RequestBody ProdutoRequest request) {
        ProdutoEntity produto = produtoService.atualizar(id, request);
        return ResponseEntity.ok(produto);
    }
}

