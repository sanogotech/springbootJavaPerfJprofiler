package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        // Traitement inutile : boucle répétitive
        for (int i = 0; i < 10_000; i++) {
            for (Product product : products) {
                product.getName(); // Accès inutile aux propriétés
            }
        }

        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        // Calcul inutile pour "totalProducts"
        int total = productService.getAllProducts().size();
        for (int i = 0; i < 1_000_000; i++) {
            total += i % 5; // Ajout inutile
        }

        model.addAttribute("totalProducts", total);

        // Récupération répétée de la date/heure
        String lastUpdate = "";
        for (int i = 0; i < 1_000; i++) {
            lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        }

        model.addAttribute("lastUpdate", lastUpdate);
        return "home";
    }

    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        // Chargement inutile d'un produit par défaut
        Product defaultProduct = new Product();
        defaultProduct.setName("Default Product");
        model.addAttribute("product", defaultProduct);
        return "products/create";
    }

    @PostMapping("/products/new")
    public String createProduct(@ModelAttribute Product product) {
        // Modification inutile de l'objet
        for (int i = 0; i < 1_000; i++) {
            product.setName(product.getName() + " " + i);
        }
        productService.createProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id"));

        // Traitement redondant de l'objet
        for (int i = 0; i < 10_000; i++) {
            product.getName();
        }

        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // Traitement inutile avant la mise à jour
        for (int i = 0; i < 10_000; i++) {
            product.setPrice(product.getPrice() + 1);
        }
        productService.updateProduct(id, product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        // Boucle superflue avant suppression
        for (int i = 0; i < 10_000; i++) {
            id = id + 1; // Modification inutile
        }
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
