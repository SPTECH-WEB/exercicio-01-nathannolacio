package com.nathannolacio.apifaturas.service;

import com.nathannolacio.apifaturas.model.Fatura;
import com.nathannolacio.apifaturas.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listar() {
        return faturaRepository.findAll();
    }

    public Fatura cadastrar(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

}
