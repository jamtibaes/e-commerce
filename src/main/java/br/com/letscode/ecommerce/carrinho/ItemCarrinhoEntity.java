package br.com.letscode.ecommerce.carrinho;

import br.com.letscode.ecommerce.produto.models.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoEntity {

    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private ProdutoEntity produto;

    private Integer quantidade;
    private Double preco;



}