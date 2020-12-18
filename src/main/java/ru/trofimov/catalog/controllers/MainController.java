package ru.trofimov.catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.catalog.model.Product;
import ru.trofimov.catalog.service.ProductService;
import ru.trofimov.catalog.service.ProductServiceImpl;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex(Model model) {
        ProductService service = new ProductServiceImpl();
        List<Product> list = service.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @PostMapping("/")
    public String search(Model model, @RequestParam String search) {
        ProductService service = new ProductServiceImpl();
        List<Product> list = service.search(search);
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String name, @RequestParam String description) {
        Product product = new Product(toUTF8(name), toUTF8(description));
        ProductService service = new ProductServiceImpl();
        service.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") int id) {
        ProductService service = new ProductServiceImpl();
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String addPost(@RequestParam String name,
                          @RequestParam String description,
                          @PathVariable(value = "id") int id) {
        ProductService service = new ProductServiceImpl();
        Product product = new Product(toUTF8(name), toUTF8(description));
        product.setId(id);
        service.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        System.out.println("id = " + id);
        ProductService service = new ProductServiceImpl();
        Product product = service.findById(id);
        service.delete(product);
        return "redirect:/";
    }

    private String toUTF8(String string) {
        return new String(string.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}