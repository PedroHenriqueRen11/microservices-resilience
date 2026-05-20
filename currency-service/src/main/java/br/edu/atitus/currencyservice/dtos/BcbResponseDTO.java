package br.edu.atitus.currencyservice.dtos;

import java.util.List;

public class BcbResponseDTO {
    
    private List<CotacaoDTO> value;

    public List<CotacaoDTO> getValue() {
        return value;
    }

    public void setValue(List<CotacaoDTO> value) {
        this.value = value;
    }

    public static class CotacaoDTO {
        private Double cotacaoVenda;

        public Double getCotacaoVenda() {
            return cotacaoVenda;
        }

        public void setCotacaoVenda(Double cotacaoVenda) {
            this.cotacaoVenda = cotacaoVenda;
        }
    }
}