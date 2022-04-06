package br.com.letscode.ecommerce.carrinho;

import br.com.letscode.ecommerce.produto.models.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAlteracao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoEntity> itens = new ArrayList<>();

    public void adicionarItem(ProdutoEntity produto) {
        this.itens.add(produto);
    }

    public void removerItem(ProdutoEntity produto) {
        this.itens.remove(produto);
    }



/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoEntity> itens = new ArrayList<>();

    private ZonedDateTime dataCriacao;

    public void adicionarProduto(ProdutoEntity produto, Integer quantidade) {
        ItemCarrinhoEntity itemCarrinho = new ItemCarrinhoEntity();
        itemCarrinho.setProduto(produto);
        itemCarrinho.setQuantidade(quantidade);
        itens.add(itemCarrinho);
    }

    public void removerProduto(ProdutoEntity produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public void atualizarQuantidade(ProdutoEntity produto, Integer quantidade) {
        itens.forEach(item -> {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(quantidade);
            }
        });
    }

    public Double getValorTotal() {
        return itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();
    }
    */


}
