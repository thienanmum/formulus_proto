package org.cas.formulus.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.cas.formulus.entity.Formulation;
import org.cas.formulus.service.FormulationService;
import org.springframework.stereotype.Service;

@Service
public class FormulationServiceImpl implements FormulationService {

	@Override
	public Collection<Formulation> getAllFormulation() {
		Collection<Formulation> result = new ArrayList<Formulation>();
		
		// Dummy
		Formulation f1 = new Formulation();
		f1.setId(1);
		f1.setApplicationTechnique("Spray");
		f1.setPhysicalForm("Liquid");
		f1.setTarget("Fusarium");
		
		result.add(f1);
		
		return result;
	}

	@Override
	public Formulation saveFormulation(Formulation formulation) {
		return formulation;
	}

	@Override
	public void deleteFormulation(int formulationId) {
		System.out.println("Delete Formulation with Id: " + formulationId);		
	}

	@Override
	public Formulation getFormulationById(int id) {
		// Dummy
		Formulation f1 = new Formulation();
		f1.setId(1);
		f1.setApplicationTechnique("Drink");
		f1.setPhysicalForm("Spills");
		f1.setTarget("Fusarium");
		return f1;
	}

}
