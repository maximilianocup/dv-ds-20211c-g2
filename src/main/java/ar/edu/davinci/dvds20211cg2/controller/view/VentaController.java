package ar.edu.davinci.dvds20211cg2.controller.view;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.davinci.dvds20211cg2.controller.TiendaApp;
import ar.edu.davinci.dvds20211cg2.domain.Item;
import ar.edu.davinci.dvds20211cg2.domain.Venta;
import ar.edu.davinci.dvds20211cg2.domain.VentaEfectivo;
import ar.edu.davinci.dvds20211cg2.domain.VentaTarjeta;
import ar.edu.davinci.dvds20211cg2.exception.BusinessException;
import ar.edu.davinci.dvds20211cg2.service.ClienteService;
import ar.edu.davinci.dvds20211cg2.service.PrendaService;
import ar.edu.davinci.dvds20211cg2.service.VentaService;


@Controller
public class VentaController extends TiendaApp {
	private final Logger LOGGER = LoggerFactory.getLogger(VentaController.class);

	
	@Autowired
	private VentaService ventaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PrendaService prendaService;
	
	@GetMapping(path = "ventas/list")
	public String showVentaPage(Model model) {
		LOGGER.info("GET - showVentaPage  - /ventas/list");
		
		Pageable pageable = PageRequest.of(0, 20);
		Page<Venta> ventas = ventaService.list(pageable);
		LOGGER.info("GET - showVentaPage venta importe final: " + ventas.getContent().toString());
		
		model.addAttribute("listVentas", ventas);

		LOGGER.info("ventas.size: " + ventas.getNumberOfElements());
		return "ventas/list_ventas";
	}
	
	@GetMapping(path = "ventas/tarjeta/new")
	public String showNewVentaTarjetaPage(Model model) {
		LOGGER.info("GET - showNewVentaPage - /ventas/tarjeta/new");
		Venta venta = new VentaTarjeta();
		model.addAttribute("venta", venta);
		model.addAttribute("razonSocial", venta.getRazonSocial());
		model.addAttribute("fecha", venta.getFormatoFecha());
		
	//	model.addAttribute("tipoVentas", ventaService.getTipoVentas());

		LOGGER.info("ventas: " + venta.toString());

		return "ventas/new_ventas_tarjeta";
	}
	
	@GetMapping(path = "ventas/efectivo/new")
	public String showNewVentaEfectivoPage(Model model) {
		LOGGER.info("GET - showNewVentaPage - /ventas/efectivo/new");
		Venta venta = new VentaEfectivo();
		Item item = new Item();
	//	model.addAttribute("venta", venta);
		//model.addAttribute("razonSocial", venta.getRazonSocial());
	//	model.addAttribute("fecha", venta.getFormatoFecha());
		model.addAttribute("venta", venta);
		model.addAttribute("cliente", clienteService.listAll());
		model.addAttribute("listPrendas", prendaService.list());
		model.addAttribute("item", item);
	//	model.addAttribute("tipoVentas", ventaService.getTipoVentas());

		LOGGER.info("ventas: " + venta.toString());

		return "ventas/new_ventas_efectivo";
	}
	
	@PostMapping(value = "/ventas/efectivo/save")
	public String saveVenta(@ModelAttribute("venta") VentaEfectivo venta) throws BusinessException {
		LOGGER.info("POST - saveVenta - /ventas/save");
		LOGGER.info("venta: " + venta.toString());
		ventaService.save(venta);

		return "redirect:/tienda/ventas/list";
	}
	
	@PostMapping(value = "/ventas/tarjeta/save")
	public String saveVenta(@ModelAttribute("venta") VentaTarjeta venta) throws BusinessException {
		LOGGER.info("POST - saveVenta - /ventas/save");
		LOGGER.info("venta: " + venta.toString());
		ventaService.save(venta);

		return "redirect:/tienda/ventas/list";
	}
	
	@RequestMapping(value = "/ventas/edit/{id}", method = RequestMethod.GET)
	public ModelAndView showEditVentaPage(@PathVariable(name = "id") Long ventaId) {
		LOGGER.info("GET - showEditVentaPage - /ventas/edit/{id}");
		LOGGER.info("venta: " + ventaId);

		ModelAndView mav = new ModelAndView("ventas/edit_ventas");
		try {
			
			Venta venta = ventaService.findById(ventaId);
			mav.addObject("venta", venta);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/ventas/delete/{id}", method = RequestMethod.GET)
	public String deleteVenta(@PathVariable(name = "id") Long ventaId) {
		LOGGER.info("GET - deleteVenta - /ventas/delete/{id}");
		LOGGER.info("venta: " + ventaId);
		ventaService.delete(ventaId);
		return "redirect:/tienda/ventas/list";
	}
}

