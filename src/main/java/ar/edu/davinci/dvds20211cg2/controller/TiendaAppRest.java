package ar.edu.davinci.dvds20211cg2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/tienda/api")
public abstract class TiendaAppRest {

	//8090 está configurado en la propiedad server.port
	// http://localhost:8090/tienda/api
}
