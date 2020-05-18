package springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.app.models.Raza;
import springboot.app.service.SBuscarRaza;

@Controller
public class SearchController {
	
	@Autowired
	private SBuscarRaza sbr;
	
	@GetMapping(value = "/Razas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Raza> getAll()
	{
		return sbr.getAll();
	}

}
