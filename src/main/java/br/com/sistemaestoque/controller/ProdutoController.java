package br.com.sistemaestoque.controller;

import br.com.sistemaestoque.model.Produto;
import br.com.sistemaestoque.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/inserir-produtos")
    public ModelAndView insertProdutos(Produto produto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/formProduto");
        modelAndView.addObject("produto", new Produto());
        return modelAndView;
    }

    @PostMapping("inserir-produtos")
    public ModelAndView inserirProdutoo(@Valid Produto produto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("Produto/formProduto");
            modelAndView.addObject("produto");
        } else {
        modelAndView.setViewName("redirect:/produtos-adicionados");
        produtoRepository.save(produto);
        }
        return modelAndView;
    }

    @GetMapping("produtos-adicionados")
    public ModelAndView listagemProdutos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/listProdutos");
        modelAndView.addObject("produtosList", produtoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id")Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/editar");
        Produto produto = produtoRepository.getById(id);
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(Produto produto) {
        ModelAndView modelAndView = new ModelAndView();
        produtoRepository.save(produto);
        modelAndView.setViewName("redirect:/produtos-adicionados");
        return modelAndView;
    }

    @GetMapping("/remover/{id}")
    public String removerProduto(@PathVariable("id") Long id) {
    	produtoRepository.deleteById(id);
        return "redirect:/produtos-adicionados";
    }

    @GetMapping("/filtro-produtos")
    public ModelAndView filtroProdutos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/filtroProdutos");
        return modelAndView;
    }

    @GetMapping("/produtos-informatica")
    public ModelAndView listaProdutosAtivos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/produtos-informatica");
        modelAndView.addObject("produtos", produtoRepository.findByCategoriaInformatica());
        return modelAndView;
    }

    @GetMapping("/produtos-eletrodomesticos")
    public ModelAndView listaProdutosEletrodomesticos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/produtos-eletrodomesticos");
        modelAndView.addObject("produtos", produtoRepository.findByCategoriaEletrodomestico());
        return modelAndView;
    }
    
    @GetMapping("/produtos-brinquedos")
    public ModelAndView listaProdutosBrinquedos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Produto/produtos-brinquedos");
        modelAndView.addObject("produtos", produtoRepository.findByCategoriaBrinquedo());
        return modelAndView;
    }

    @PostMapping("/pesquisar-produto")
    public ModelAndView pesquisarProduto(@RequestParam(required = false) String nome) {
        ModelAndView modelAndView = new ModelAndView();
        List<Produto> listaProdutos;
        if(nome == null || nome.trim().isEmpty()) {
        	listaProdutos = produtoRepository.findAll();
        } else {
        	listaProdutos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        }
        modelAndView.addObject("ListaDeProdutos", listaProdutos);
        modelAndView.setViewName("Produto/pesquisa-produto");
        return modelAndView;
    }
}
