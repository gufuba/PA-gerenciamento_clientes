package com.fumagalli.gerenciamento_clientes.services;

import com.fumagalli.gerenciamento_clientes.models.ClienteModel;
import com.fumagalli.gerenciamento_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public ClienteModel criarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public Optional<ClienteModel> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public ClienteModel atualizar(long id, ClienteModel clienteModel){
        ClienteModel model = clienteRepository.findById(id).get();
        model.setNome(clienteModel.getNome());
        model.setEmail(clienteModel.getEmail());
        model.setTelefone(clienteModel.getTelefone());

        return clienteRepository.save(model);
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

}
