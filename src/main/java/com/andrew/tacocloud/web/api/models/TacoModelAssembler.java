package com.andrew.tacocloud.web.api.models;

import com.andrew.tacocloud.web.api.DesignTacoControllerApi;
import com.andrew.tacocloud.web.domains.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoModelAssembler extends RepresentationModelAssemblerSupport<Taco, TacoModel> {

    public TacoModelAssembler(){
        super(DesignTacoControllerApi.class, TacoModel.class); // using DesignTacoController to determine the base path
    }
    @Override
    protected TacoModel instantiateModel(Taco entity) {
        return new TacoModel(entity);
    }

    @Override
    public TacoModel toModel(Taco entity) {  //Under the covers toModel() will call instantiateModel()
        return createModelWithId(entity.getId(), entity);
    }
}
