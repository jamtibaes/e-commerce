package br.com.letscode.ecommerce.carrinho;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;


    public List<CarrinhoEntity> listar() {
        return carrinhoRepository.findAll();
    }

    public CarrinhoEntity buscar(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }

    public CarrinhoEntity criar(CarrinhoEntity carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public CarrinhoEntity atualizar(Long id, CarrinhoEntity carrinho) {
        CarrinhoEntity carrinhoEntity = buscar(id);
        return carrinhoRepository.save(carrinhoEntity);
    }

    public void remover(Long id) {
        carrinhoRepository.deleteById(id);
    }
}

