package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.service;

import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.Cliente;
import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
