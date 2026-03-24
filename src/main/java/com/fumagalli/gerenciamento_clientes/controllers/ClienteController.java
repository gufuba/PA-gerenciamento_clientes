package com.fumagalli.gerenciamento_clientes.controllers;

import com.fumagalli.gerenciamento_clientes.models.ClienteModel;
import com.fumagalli.gerenciamento_clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> requeste = clienteService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel novo = clienteService.criarCliente(clienteModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarPorIdCliente(@PathVariable Long id){
        Optional<ClienteModel> cliente = clienteService.buscarPorId(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        ClienteModel atualizado = clienteService.atualizar(id, clienteModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
