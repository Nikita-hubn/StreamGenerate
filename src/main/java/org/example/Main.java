package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // (2) Группированы заказы по продуктам и (3) Для каждого продукта найдена общая стоимость всех заказов.
        Map<String, Double> orderGroupByProductAndTotalSumProduct = orders.stream().collect(Collectors.groupingBy(Order::getProduct,
                Collectors.summingDouble(Order::getCost)));

        // (4) Отсортируем продукты по убыванию общей стоимости и (5) Выбираем топ-3
        List<Map.Entry<String, Double>> sortedByDescProductAndTop3Products = orderGroupByProductAndTotalSumProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        // 6. Выводим результат трех самых дорогих продуктов и их общая стоимость.
        System.out.println(sortedByDescProductAndTop3Products);
    }
}