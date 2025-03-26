package com.nathannolacio.apifaturas.controller;

import com.nathannolacio.apifaturas.model.Fatura;
import com.nathannolacio.apifaturas.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaRepository faturaRepository;

    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> listarFaturas() {
        List<Fatura> faturas = faturaRepository.findAll();
        return ResponseEntity.ok(faturas);
    }

    @PostMapping
    public ResponseEntity<Fatura> cadastrarFatura(@Valid @RequestBody Fatura fatura) {
        faturaRepository.save(fatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(fatura);
    }

}
