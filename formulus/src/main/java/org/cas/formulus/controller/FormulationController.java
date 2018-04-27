package org.cas.formulus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.cas.formulus.entity.Formulation;
import org.cas.formulus.service.FormulationService;

@RequestMapping(value="/api/formulations")
@RestController
public class FormulationController {
	
	@Autowired
	private FormulationService formulationService;
	
//	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
    @GetMapping({"","/"})
	@ResponseBody
	public Collection<Formulation> getAllFormulation() {
		return formulationService.getAllFormulation();
	}
	
	@RequestMapping(value= {"","/"}, method=RequestMethod.POST)
	@ResponseBody
	public Formulation createFormulation(@RequestBody Formulation formulation) {
		formulation.setId("");
		return formulationService.saveFormulation(formulation);				
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public Formulation updateFormulation(@RequestBody Formulation formulation, @PathVariable String id) {
		formulation.setId(id);
		return formulationService.saveFormulation(formulation);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteFormulation(@PathVariable String id) {
		formulationService.deleteFormulation(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Formulation getFormulation(@PathVariable String id) {
		return formulationService.getFormulationById(id);
	}	
}
