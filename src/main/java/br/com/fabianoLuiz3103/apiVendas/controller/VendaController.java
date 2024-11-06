package br.com.fabianoLuiz3103.apiVendas.controller;

import br.com.fabianoLuiz3103.apiVendas.dto.CadastroVenda;
import br.com.fabianoLuiz3103.apiVendas.dto.LeituraVenda;
import br.com.fabianoLuiz3103.apiVendas.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<LeituraVenda> insert(
            @RequestBody @Valid CadastroVenda cadastroVenda
            ){

        var venda = vendaService.insert(cadastroVenda);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(venda.id())
                .toUri();

        return ResponseEntity.created(uri).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<LeituraVenda>> findAll(){
        var vendas = vendaService.findAll();
        return ResponseEntity.ok().body(vendas);
    }
}
