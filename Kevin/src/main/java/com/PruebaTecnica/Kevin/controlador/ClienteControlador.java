package com.PruebaTecnica.Kevin.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.PruebaTecnica.Kevin.facadeImpl.ClienteDAO;
import com.PruebaTecnica.Kevin.modelo.Cliente;


@Controller
public class ClienteControlador {

	@Autowired
	private ClienteDAO CD;

	/* Show */
	@GetMapping({ "/clientes", "/" })

	public String listarCliente(Model modelo) {
		modelo.addAttribute("clientes", CD.listarTodosLosClientes());
		return "clientes";
	}

	@GetMapping("/listar")

	public ResponseEntity<Map<String, Object>> allClientes() {
		Map<String, Object> respon = new HashMap<String, Object>();

		try {
			List<Cliente> lstC = CD.listarTodosLosClientes();

			respon.put("Mensaje", "Se listo correctamente los clientes");
			respon.put("data", lstC);
			respon.put("Status", HttpStatus.OK);

		} catch (Exception e) {
			respon.put("Mensaje", "Fallo el listar de los clientes");
			respon.put("Status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(respon, HttpStatus.OK);
	}

	/* Show */

	/* create */
	@PostMapping("/crear")
	public ResponseEntity<Map<String, Object>> createUsuario(@RequestBody Map<String, Object> request) {

		Map<String, Object> respon = new HashMap<String, Object>();

		try {
			Cliente cli = new Cliente();
			cli.setApellido((String) request.get("Apellido"));
			cli.setCiudad((String) request.get("Ciudad"));
			cli.setCorreo((String) request.get("Correo"));
			cli.setFecha_Nacimiento((String) request.get("Fecha_Nacimiento"));
			cli.setNombre((String) request.get("Nombre"));
			cli.setOcupacion((String) request.get("Ocupacion"));
			cli.setTelefono((String) request.get("Telefono"));
			this.CD.guardarCliente(cli);
			respon.put("Mensaje", "Correcto");
			respon.put("data", request);
			respon.put("Status", HttpStatus.OK);
		} catch (Exception e) {
			respon.put("Mensaje", "incorrecto");
			return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(respon, HttpStatus.OK);
	}

	@GetMapping("/clientes/nuevo")
	public String mostrarFormularioDeRegistrtarUsuarios(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("clientes", cliente);
		return "Crear_Cliente";
	}

	@PostMapping("/clientes")
	public String guardarUsuario(@ModelAttribute("cliente") Cliente cliente) {
		CD.guardarCliente(cliente);
		return "redirect:/clientes";
	}
	/* create */

	/* Update */
	@GetMapping(path = "/actualizar/{Numero_documento}")
	public ResponseEntity<Map<String, Object>> actualizar(@PathVariable String Numero_documento,
			@RequestBody Map<String, Object> request) {
		Map<String, Object> respon = new HashMap<String, Object>();

		try {
			Cliente Cli = this.CD.obtenerClientePorId(Integer.parseInt(Numero_documento));

			Cli.setApellido((String) request.get("Apellido"));
			Cli.setCiudad((String) request.get("Ciudad"));
			Cli.setCorreo((String) request.get("Correo"));
			Cli.setFecha_Nacimiento((String) request.get("Fecha_Nacimiento"));
			Cli.setNombre((String) request.get("Nombre"));
			Cli.setOcupacion((String) request.get("Ocupacion"));
			Cli.setTelefono((String) request.get("Telefono"));
			this.CD.guardarCliente(Cli);
			respon.put("Message", "La base de datos se ha actualizado");
			respon.put("data", request);
			respon.put("Status", HttpStatus.OK);

		} catch (Exception e) {
			respon.put("Message", "La base de datos no se ha actualizado");
			respon.put("Status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(respon, HttpStatus.OK);
	}

	@GetMapping("/clientes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("clientes", CD.obtenerClientePorId(id));
		return "Editar_Cliente";
	}

	@PostMapping("/clientes/{id}")
	public String actualizarEstudiante(@PathVariable Integer id, @ModelAttribute("usuario") Cliente cliente,
			Model modelo) {
		Cliente Cliente = CD.obtenerClientePorId(id);
		Cliente.setNumero_documento(id);
		Cliente.setNombre(cliente.getNombre());
		Cliente.setApellido(cliente.getApellido());
		Cliente.setFecha_Nacimiento(cliente.getFecha_Nacimiento());
		Cliente.setCiudad(cliente.getCiudad());
		Cliente.setCorreo(cliente.getCorreo());
		Cliente.setTelefono(cliente.getTelefono());
		Cliente.setOcupacion(cliente.getOcupacion());

		CD.actualizarCliente(Cliente);
		return "redirect:/clientes";
	}
	
	/* Update */
	
	/*Delete*/
	@GetMapping (path ="/eliminar/{Numero_documento}")
	public ResponseEntity <Map<String, Object>> eliminarclient(
			@PathVariable String Numero_documento){
		 Map<String, Object> respon= new HashMap<String,Object>();  
			
		 try {
			Cliente c =this.CD.obtenerClientePorId(Integer.parseInt(Numero_documento));
			this.CD.actualizarCliente(c);
			respon.put("Mensaje","Eliminacion exitosa");
			List<Cliente> lstC= this.CD.listarTodosLosClientes();
			respon.put("data", lstC);
			respon.put("status", HttpStatus.OK);
		} catch (Exception e) {
			respon.put("Mensaje", "Eliminacion fallida");
			respon.put("status", HttpStatus.BAD_REQUEST);
		}
		 
		 
		 return new ResponseEntity<>(respon, HttpStatus.OK);

	}
	
	@GetMapping("/clientes/{id}")
	public String eliminarCliente(@PathVariable Integer id) {
		CD.eliminarCliente(id);
		return "redirect:/clientes";
	}
	
	/*Delete*/
	
}
