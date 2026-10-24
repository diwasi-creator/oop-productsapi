package uk.ac.westminster.productsapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;          // <-- NEW

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        products.add(new DigitalProduct(nextId++,"Clean code (E-book)",29.9,
                "/downloads/clean-code.pdf",4.2));

        products.add(new PhysicalProduct(nextId++,"27-inch Monitor",249.99,
                5.4,"61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }


    public Optional<Product> getProductById(Long id) {      // <-- NEW
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}