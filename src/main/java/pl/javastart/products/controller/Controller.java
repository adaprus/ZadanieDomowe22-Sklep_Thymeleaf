package pl.javastart.products.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.products.model.Product;
import pl.javastart.products.repository.ProductsRepository;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private ProductsRepository productsRepository;

    public Controller(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/add")
    @ResponseBody
    public String addProduct(@RequestParam String name,
                             @RequestParam double price) {
        try {
            Product product = new Product(name, price);
            productsRepository.addProduct(product);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Dodano produkt";
    }

    @GetMapping("/lista")
    public String productsList(Model model){
        List<Product> productList = productsRepository.getAll();
        model.addAttribute("productList", productList);
        return "lista";
    }

    @GetMapping("/tabela")
    public String productsTab(Model model){
        List<Product> productList = productsRepository.getAll();
        model.addAttribute("productList", productList);
        return "tabela";
    }
}
