package com.fumagalli.gerenciamento_clientes.repositories;

import com.fumagalli.gerenciamento_clientes.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
