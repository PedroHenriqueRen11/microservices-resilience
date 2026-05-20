package br.edu.atitus.currencyservice.controllers;

import br.edu.atitus.currencyservice.clients.BCBClient;
import br.edu.atitus.currencyservice.clients.BCBResponse;
import br.edu.atitus.currencyservice.dtos.CurrencyDTO;
import br.edu.atitus.currencyservice.entities.CurrencyEntity;
import br.edu.atitus.currencyservice.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyController {

    @Value("${server.port}")
    private String port;

    @Value("${convert.sleep:0}")
    private int sleep;

    private final CurrencyRepository repository;
    private final BCBClient bcbClient;

    public CurrencyController(CurrencyRepository repository, BCBClient bcbClient) {
        this.repository = repository;
        this.bcbClient = bcbClient;
    }

    @GetMapping("/convert")
    public ResponseEntity<CurrencyDTO> getConvert(
            @RequestParam String source,
            @RequestParam String target) throws Exception {

        Thread.sleep(sleep);

        source = source.toUpperCase();
        target = target.toUpperCase();

        CurrencyEntity currency = repository.findBySourceCurrencyAndTargetCurrency(source, target)
                .orElseThrow(() -> new Exception("Currency not found"));

        String environment = "Currency-service running on port: " + port;

        CurrencyDTO dto = new CurrencyDTO(currency.getSourceCurrency(),
                currency.getTargetCurrency(),
                currency.getConversionRate(),
                environment);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/bcb")
    public ResponseEntity<?> getCotacaoBCB(
            @RequestParam String moeda) {

        BCBResponse response = bcbClient.getCotacao(
                "'" + moeda.toUpperCase() + "'",
                "'05-12-2025'",
                "json");

        if (response == null || response.getValue() == null || response.getValue().isEmpty()) {
            return ResponseEntity.ok("Fallback: cotação não disponível");
        }

        return ResponseEntity.ok(response.getValue());
    }
}