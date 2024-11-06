package br.com.fabianoLuiz3103.apiVendas.service;

import br.com.fabianoLuiz3103.apiVendas.dto.CadastroVenda;
import br.com.fabianoLuiz3103.apiVendas.dto.LeituraVenda;
import br.com.fabianoLuiz3103.apiVendas.model.Venda;
import br.com.fabianoLuiz3103.apiVendas.repository.VendaRepository;
import br.com.fabianoLuiz3103.apiVendas.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public LeituraVenda insert(CadastroVenda cadastroVenda){
        var venda = new Venda(cadastroVenda.venda());
        var vendedor = vendedorRepository.findById(cadastroVenda.vendedor().id()).
                orElseThrow(()->new EntityNotFoundException("Recurso não encontrado com id:" + cadastroVenda.vendedor().id()));
        venda.setComissao(calculaComissao(cadastroVenda.venda().total()));
        venda.setStatus(calculaStatus(cadastroVenda.venda().total()));
        venda.setVendedor(vendedor);
        venda = vendaRepository.save(venda);

        return new LeituraVenda(venda);
    }

    @Transactional(readOnly = true)
    public List<LeituraVenda> findAll(){
        var vendas = vendaRepository.findAll();
        return vendas.stream().map(LeituraVenda::new).toList();
    }

    @Transactional(readOnly = true)
    public LeituraVenda findById(Long id){
        var venda = vendaRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new LeituraVenda(venda);
    }


    private Double calculaComissao(Double valor){
        return valor*0.1;
    }

    private String calculaStatus(Double valor){
        if(valor < 15000){
            return "BAIXA";
        } else if(valor > 15000 && valor < 30000){
            return "MEDIA";
        } else {
            return "ALTA";
        }
    }
}
