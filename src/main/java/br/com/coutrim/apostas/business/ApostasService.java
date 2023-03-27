package br.com.coutrim.apostas.business;

import br.com.coutrim.apostas.dao.ApostasDAO;
import br.com.coutrim.apostas.model.Apostas;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ApostasService {

    @Inject
    ApostasDAO apostasDAO;

    /*public List<ApostasDto> listarApostas(){
        List<Long> apostas = apostasDAO.buscarApostas();

    }*/
}
