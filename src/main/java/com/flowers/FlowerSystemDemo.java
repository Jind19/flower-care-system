package com.flowers;

import java.util.*;

public class FlowerSystemDemo {
    public static void main(String[] args) {

        // Sample flowers with care actions
        Flower rose = new Flower("Rose", Arrays.asList("Water", "Prune", "Fertilize"));
        Flower tulip = new Flower("Tulip", Arrays.asList("Water", "Weed"));
        Flower daisy = new Flower("Daisy", Arrays.asList("Water", "Deadhead"));

        Flower sunflower = new Flower("Sunflower", Arrays.asList("Water", "Stake"));
        Flower orchid = new Flower("Orchid", Arrays.asList("Water", "Mist", "Fertilize"));

        // Sample gardeners with assigned flowers
        Gardener alice = new Gardener("Alice", Arrays.asList(rose, tulip));
        Gardener bob = new Gardener("Bob", Arrays.asList(daisy, sunflower));
        Gardener claire = new Gardener("Claire", Arrays.asList(orchid, rose));

        // List of gardeners
        List<Gardener> gardeners = Arrays.asList(alice, bob, claire);

        // Instantiate FlowerService
        FlowerService service = new FlowerService();

        // Call flattenCareActions and print
        List<String> allCareActions = service.flattenCareActions(gardeners);
        System.out.println("All care actions (flattened): " + allCareActions);

        // Call countFlowersByType and print
        Map<String, Long> flowerCount = service.countFlowersByType(gardeners);
        System.out.println("Flower count by type: " + flowerCount);

        // Call collectUniqueCareActions and print
        Set<String> uniqueCareActions = service.collectUniqueCareActions(gardeners);
        System.out.println("Unique care actions: " + uniqueCareActions);

    }
}
