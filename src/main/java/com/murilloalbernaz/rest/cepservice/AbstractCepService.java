package com.murilloalbernaz.rest.cepservice;

import com.murilloalbernaz.rest.model.EnderecoIngles;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.logging.Logger;

public abstract class AbstractCepService implements CepService {
    private static final Logger LOG = Logger.getLogger(AbstractCepService.class.getName());
    private final WebTarget target;
    private String dominio;

    public AbstractCepService(String dominio) {
        this.dominio = insetTrailingSlash(dominio);
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }

    protected String insetTrailingSlash(String path){
        return path.endsWith("/") ? path : path+"/";
    }

    protected abstract String buildPath(String cep);

    protected String getFullPath(String cep){
        return this.dominio +buildPath(cep);
    }

    @Override
    public EnderecoIngles buscaEndereco(String cep) {
        LOG.info(String.format("Buscando endereço para o CEP %s usando serviço %s", cep,dominio));
        return target.path(buildPath(cep)).request().get(EnderecoIngles.class);
    }
}
