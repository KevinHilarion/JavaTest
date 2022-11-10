package com.PruebaTecnica.Kevin.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PruebaTecnica.Kevin.facade.ICliente;
import com.PruebaTecnica.Kevin.modelo.Cliente;
import com.PruebaTecnica.Kevin.repositorio.ClienteRepositorio;

@Service
public class ClienteDAO implements ICliente{

	@Autowired
	private ClienteRepositorio Cr;

	@Override
	public List<Cliente> listarTodosLosClientes() {
		return Cr.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return Cr.save(cliente);
	}

	@Override
	public Cliente obtenerClientePorId(Integer Numero_documento) {
		return Cr.findById(Numero_documento).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return Cr.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer Numero_documento) {
		Cr.deleteById(Numero_documento);
		
	}
}
