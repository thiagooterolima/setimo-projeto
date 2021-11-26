package br.edu.unifio.setimoprojeto.bean;


import br.edu.unifio.setimoprojeto.domain.Categoria;
import br.edu.unifio.setimoprojeto.domain.Produto;
import br.edu.unifio.setimoprojeto.repository.CategoriaRepository;
import br.edu.unifio.setimoprojeto.repository.ProdutoRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.faces.view.ViewScoped;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
@Data
public class ProdutoBean {
    private Produto produto;
    private List<Categoria> categorias;
    private List<Produto> produtos;


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void novo() {
        produto = new Produto ();

        RestTemplate restTemplate = new RestTemplate();
        Categoria[] vetor = restTemplate.getForObject("http://localhost:8080/categorias",Categoria[].class);
        categorias = Arrays.asList(vetor);
    }

    public void listar() {

        //produtos = produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));

         RestTemplate restTemplate = new RestTemplate();
         Produto[] vetor = restTemplate.getForObject("http://localhost:8080/produtos", Produto[].class);
         produtos = Arrays.asList(vetor);
    }

    public void selecionarExclusao(Produto produto){

        Faces.setFlashAttribute("produto",produto);
        Faces.navigate("produto-exclusao.xhtml?faces-redirect=true");
    }


    public void selecionarEdicao(Produto produto) {
        Faces.setFlashAttribute("produto", produto);
        Faces.navigate("produto-edicao.xhtml?faces-redirect=true");
    }

    public void carregar(){
         produto = Faces.getFlashAttribute("produto");

        RestTemplate restTemplate = new RestTemplate();
        Categoria[] vetor = restTemplate.getForObject("http://localhost:8080/categorias",Categoria[].class);
        categorias = Arrays.asList(vetor);

         }



    public void salvar () {
            try {
                produtoRepository.save(produto);
                Messages.addFlashGlobalInfo("Produto salva com sucesso");


                Faces.navigate("produto-listagem.xhtml?faces-redirect=true");

            } catch (DataIntegrityViolationException excecao) {
                Messages.addGlobalInfo("Ja existe um Produto");
            }

         }





    public void editar () {
        try {
            produtoRepository.save(produto);
            Messages.addFlashGlobalInfo("Produto editado com sucesso");


            Faces.navigate("produto-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            Messages.addGlobalInfo("Ja existe esse Produto");
        }

    }




    public void excluir () {
        try {
            produtoRepository.deleteById(produto.getCodigo());
            Messages.addFlashGlobalInfo("Produto excluido com sucesso");


            Faces.navigate("produto-listagem.xhtml?faces-redirect=true");

        } catch (DataIntegrityViolationException excecao) {
            Messages.addGlobalInfo("O produto selecionado esta vinculado a outros registros");
        }

    }










}
