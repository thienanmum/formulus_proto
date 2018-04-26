package org.cas.formulus.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.cas.formulus.data.FormulationRepo;
import org.cas.formulus.entity.Formulation;
import org.cas.formulus.service.FormulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormulationServiceImpl implements FormulationService {
	@Autowired
	private FormulationRepo repo;

	@Override
	public Collection<Formulation> getAllFormulation() {
		return repo.getAll();
	}

	@Override
	public Formulation saveFormulation(Formulation formulation) {
		if (formulation.getId() == null || formulation.getId() == "") {
			return repo.insert(formulation);
		} else {
			return repo.update(formulation);
		}
	}

	@Override
	public void deleteFormulation(String formulationId) {
		System.out.println("Delete Formulation with Id: " + formulationId);
		repo.delete(formulationId);
	}

	@Override
	public Formulation getFormulationById(String formulationId) {
		return repo.getById(formulationId);
	}

}
