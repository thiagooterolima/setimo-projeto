package br.edu.unifio.setimoprojeto.resource;



import br.edu.unifio.setimoprojeto.domain.Produto;
import br.edu.unifio.setimoprojeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoResource {
    @Autowired
    private ProdutoRepository produtoRepositoryRepository;

    @GetMapping
    public List<Produto> listar(){
        List<Produto> produtos = produtoRepositoryRepository.findAll(Sort.by(Sort.Direction.ASC,"nome"));
        return produtos;
    }
}
