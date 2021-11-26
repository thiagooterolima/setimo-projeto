package br.edu.unifio.setimoprojeto.bean;

import br.edu.unifio.setimoprojeto.domain.Cidade;
import br.edu.unifio.setimoprojeto.domain.Estado;
import br.edu.unifio.setimoprojeto.repository.CidadaRepository;
import br.edu.unifio.setimoprojeto.repository.EstadoRepository;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ViewScoped
@Data
public class CidadeBean {
    private Cidade cidade;
    private List<Estado> estados;

    @Autowired
    private CidadaRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public void novo() {
        cidade = new Cidade();
        estados = estadoRepository.findAll(Sort.by(Sort.Direction.ASC,"nome"));
    }


    public void salvar(){
        try {
            cidadeRepository.save(cidade);
            Messages.addGlobalInfo("Cidade salva com sucesso");
            novo();


        }catch (DataIntegrityViolationException excecao){
            Messages.addGlobalInfo("Ja existe essa cidade");
        }
    }
}
