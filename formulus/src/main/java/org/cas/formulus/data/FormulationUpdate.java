package org.cas.formulus.data;

import com.basho.riak.client.api.commands.kv.UpdateValue;
import org.cas.formulus.entity.Formulation;

public class FormulationUpdate extends UpdateValue.Update<Formulation> {
    private Formulation update;
    public FormulationUpdate(Formulation update) {
        this.update = update;
    }

    @Override
    public Formulation apply(Formulation original) {
        if (original == null) {
            original = new Formulation();
        }
        original.copy(update);
        return null;
    }
}
