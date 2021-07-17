package ar.edu.davinci.dvds20211cg2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/tienda")
public abstract class TiendaApp {
	//8090 está configurado en la propiedad server.port
	// http://localhost:8090/tienda

}
