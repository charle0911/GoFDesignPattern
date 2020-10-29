package com.design.pattern.solid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
    // state space explosion
    // 3 criteria = 7 methods
}

// we introduce two new interfaces that are open for extension
interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {
    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}

class ChainSpecification<T> implements Specification<T> {
    private final List<Specification<T>> specifications;

    @SafeVarargs
    public ChainSpecification(Specification<T>... first) {
        this.specifications = Arrays.stream(first).collect(Collectors.toList());
    }

    @Override
    public boolean isSatisfied(T item) {
        return specifications.stream().allMatch(x -> x.isSatisfied(item));
    }


}

class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        // Design without following open-closed principle
        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old):");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " is green"));


        // Design with following open-closed principle
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new):");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        System.out.println("Large products:");
        bf.filter(products, new SizeSpecification(Size.LARGE))
                .forEach(p -> System.out.println(" - " + p.name + " is large"));

        System.out.println("Large blue items:");
        bf.filter(products,
                new ChainSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.LARGE)
                ))
                .forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
    }

}