package com.murilloalbernaz.rest.cepservice;


import com.murilloalbernaz.rest.model.EnderecoIngles;

public interface CepService {
    EnderecoIngles buscaEndereco(String cep);
}
