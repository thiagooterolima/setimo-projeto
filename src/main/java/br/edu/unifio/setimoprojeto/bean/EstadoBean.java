package br.edu.unifio.setimoprojeto.bean;
import br.edu.unifio.setimoprojeto.domain.Categoria;
import br.edu.unifio.setimoprojeto.domain.Estado;
import br.edu.unifio.setimoprojeto.repository.CategoriaRepository;
import br.edu.unifio.setimoprojeto.repository.EstadoRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;


@Component
@ViewScoped
@Data
public class EstadoBean {
    private Estado estado;

    @Autowired
    private EstadoRepository estadoRepository;

    public void novo(){estado = new Estado();}


    public void salvar(){
        try {
            estadoRepository.save(estado);
            Messages.addGlobalInfo("Estado salva com sucesso");
            novo();


        }catch (DataIntegrityViolationException excecao){
            Messages.addGlobalInfo("Ja existe uma categoria");
        }
    }
}
