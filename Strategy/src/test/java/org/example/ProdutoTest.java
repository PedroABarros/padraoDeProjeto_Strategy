package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class ServicoRecomendacaoTest {

    @Test
    void deveRecomendarProdutosPorPopularidade() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", "Eletrônicos", 200, 50));
        produtos.add(new Produto("Produto B", "Eletrônicos", 150, 80));
        produtos.add(new Produto("Produto C", "Casa", 100, 30));

        ServicoRecomendacao servico = new ServicoRecomendacao();
        servico.setEstrategia(new RecomendacaoPorPopularidade());
        List<Produto> recomendados = servico.recomendarProdutos(produtos);

        assertEquals(3, recomendados.size());
        assertEquals("Produto B", recomendados.get(0).getNome()); // O mais popular
        assertEquals("Produto A", recomendados.get(1).getNome());
        assertEquals("Produto C", recomendados.get(2).getNome());
    }

    @Test
    void deveRecomendarProdutosPorPreco() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", "Eletrônicos", 200, 50));
        produtos.add(new Produto("Produto B", "Eletrônicos", 150, 80));
        produtos.add(new Produto("Produto C", "Casa", 100, 30));

        ServicoRecomendacao servico = new ServicoRecomendacao();
        servico.setEstrategia(new RecomendacaoPorPreco());
        List<Produto> recomendados = servico.recomendarProdutos(produtos);

        assertEquals(3, recomendados.size());
        assertEquals("Produto C", recomendados.get(0).getNome()); // O mais barato
        assertEquals("Produto B", recomendados.get(1).getNome());
        assertEquals("Produto A", recomendados.get(2).getNome());
    }

    @Test
    void deveRecomendarProdutosPorCategoria() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", "Eletrônicos", 200, 50));
        produtos.add(new Produto("Produto B", "Eletrônicos", 150, 80));
        produtos.add(new Produto("Produto C", "Casa", 100, 30));

        ServicoRecomendacao servico = new ServicoRecomendacao();
        servico.setEstrategia(new RecomendacaoPorCategoria("Eletrônicos"));
        List<Produto> recomendados = servico.recomendarProdutos(produtos);

        assertEquals(2, recomendados.size());
        assertEquals("Produto A", recomendados.get(0).getNome());
        assertEquals("Produto B", recomendados.get(1).getNome());
    }

    @Test
    void naoDeveRecomendarProdutosSemEstrategiaDefinida() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", "Eletrônicos", 200, 50));

        ServicoRecomendacao servico = new ServicoRecomendacao();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            servico.recomendarProdutos(produtos);
        });

        assertEquals("Estratégia não definida.", exception.getMessage());
    }
}