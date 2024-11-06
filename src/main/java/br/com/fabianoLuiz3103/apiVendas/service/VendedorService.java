package br.com.fabianoLuiz3103.apiVendas.service;

import br.com.fabianoLuiz3103.apiVendas.dto.DadosVendedor;
import br.com.fabianoLuiz3103.apiVendas.model.Vendedor;
import br.com.fabianoLuiz3103.apiVendas.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Transactional
    public DadosVendedor insert(DadosVendedor dadosVendedor){
        var vendedor = new Vendedor(dadosVendedor);
        vendedor = vendedorRepository.save(vendedor);
        return new DadosVendedor(vendedor);
    }

    @Transactional(readOnly = true)
    public List<DadosVendedor> findAll(){
        var vendedores = vendedorRepository.findAll();
        return vendedores.stream().map(DadosVendedor::new).toList();
    }

    @Transactional(readOnly = true)
    public DadosVendedor findById(Long id){
        var vendedor = vendedorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new DadosVendedor(vendedor);
    }
}
