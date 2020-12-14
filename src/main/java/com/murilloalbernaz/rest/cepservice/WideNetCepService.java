package com.murilloalbernaz.rest.cepservice;

import javax.enterprise.context.Dependent;

@Dependent
public class WideNetCepService extends AbstractCepService {
    public WideNetCepService() {
        super("https://cep.widenet.host");
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("busca-cep/api/cep/%s.json",cep);
    }
}
