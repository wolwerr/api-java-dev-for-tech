package com.br.devForTech.ApiAngular.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.devForTech.ApiAngular.modelViews.Erro;
import com.br.devForTech.ApiAngular.models.Empresa;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EmpresasController {
    @GetMapping("/empresa.json")
    public List<Empresa> index(){
        return Empresa.todos();
    }

    @PostMapping("/empresa.json")
    public ResponseEntity<Object> create(@RequestBody Empresa empresa){
        empresa.setId(Empresa.todos().size() + 1);

        if(empresa.getRazao() == null || empresa.getRazao().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("A razão é obrigatório"));
        }

        if(empresa.getCnpj() == null || empresa.getCnpj().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O CNPJ é obrigatório"));
        }

        if(empresa.getCep() == null || empresa.getCep().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O Cep é obrigatório"));
        }

        if(empresa.getRua() == null || empresa.getRua().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("A Rua é obrigatório"));
        }

        if(empresa.getNumero() == null || empresa.getNumero().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O numero é obrigatório"));
        }

        if(empresa.getBairro() == null || empresa.getBairro().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O bairro é obrigatório"));
        }

        if(empresa.getCidade() == null || empresa.getCidade().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("A cidade é obrigatório"));
        }

        if(empresa.getEstado() == null || empresa.getEstado().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O Estado é obrigatório"));
        }

        if(empresa.getValorFrete() == null || empresa.getValorFrete().isNaN()){
            return ResponseEntity.status(400).body(new Erro("O valor do frete é obrigatório"));
        }

        Empresa.add(empresa);
        return ResponseEntity.status(200).body(empresa);
    }

    @GetMapping("/empresa/{id}.json")
    public Empresa create(@PathVariable int id){
        var empresa = buscaPorId(id);
        return empresa;
    }

    @DeleteMapping("/empresas/{id}.json")
    public Empresa delete(int id){
        var empresa = buscaPorId(id);
        var empresas = Empresa.todos();
        empresas.remove(empresa);
        Empresa.set(empresas);
        return empresa;
    }

    private Empresa buscaPorId(int id) {
        var empresa = new Empresa();
        for (Empresa c : Empresa.todos()) {
            if(c.equals(id)){
                empresa = c;
                break;
            }
        }

        return empresa;
    }
}
