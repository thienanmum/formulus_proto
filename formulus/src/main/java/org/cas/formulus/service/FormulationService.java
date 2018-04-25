package org.cas.formulus.service;

import java.util.Collection;

import org.cas.formulus.entity.Formulation;

public interface FormulationService {
	Collection<Formulation> getAllFormulation();
	Formulation saveFormulation(Formulation formulation);
	void deleteFormulation(int formulationId);
	Formulation getFormulationById(int id);
}
