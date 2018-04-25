package org.cas.formulus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.cas.formulus.entity.Formulation;
import org.cas.formulus.service.FormulationService;

@RequestMapping(value="/api/formulations")
@RestController
public class FormulationController {
	
	@Autowired
	private FormulationService formulationService;
	
	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	@ResponseBody
	public Collection<Formulation> getAllFormulation() {
		return formulationService.getAllFormulation();
	}
	
	@RequestMapping(value= {"","/"}, method=RequestMethod.POST)
	public Formulation createFormulation(@RequestBody Formulation formulation) {
		formulation.setId(0);
		return formulationService.saveFormulation(formulation);				
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Formulation updateFormulation(@RequestBody Formulation formulation, @PathVariable int id) {
		formulation.setId(id);
		return formulationService.saveFormulation(formulation);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteFormulation(@PathVariable int id) {
		formulationService.deleteFormulation(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Formulation getFormulation(@PathVariable int id) {
		return formulationService.getFormulationById(id);
	}	
}
