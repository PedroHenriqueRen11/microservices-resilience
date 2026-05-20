package br.edu.atitus.currencyservice.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BCBResponse {

    @JsonProperty("value")
    private List<CotacaoItem> value;

    public List<CotacaoItem> getValue() {
        return value;
    }

    public void setValue(List<CotacaoItem> value) {
        this.value = value;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CotacaoItem {

        @JsonProperty("cotacaoCompra")
        private Double cotacaoCompra;

        @JsonProperty("cotacaoVenda")
        private Double cotacaoVenda;

        @JsonProperty("dataHoraCotacao")
        private String dataHoraCotacao;

        public Double getCotacaoCompra() { return cotacaoCompra; }
        public void setCotacaoCompra(Double cotacaoCompra) { this.cotacaoCompra = cotacaoCompra; }

        public Double getCotacaoVenda() { return cotacaoVenda; }
        public void setCotacaoVenda(Double cotacaoVenda) { this.cotacaoVenda = cotacaoVenda; }

        public String getDataHoraCotacao() { return dataHoraCotacao; }
        public void setDataHoraCotacao(String dataHoraCotacao) { this.dataHoraCotacao = dataHoraCotacao; }
    }
}
