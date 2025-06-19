package com.flowers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlowerService {

    // Flatten gardener → flowers → care actions into a flat list of all care actions
    public List<String> flattenCareActions(List<Gardener> gardeners) {
        return gardeners.stream()
                .flatMap(gardener -> gardener.getAssignedFlowers().stream()) // gardener → flowers
                .flatMap(flower -> flower.getCareActions().stream())         // flower → care actions
                .collect(Collectors.toList());
    }

    // Count how many flowers exist per flower type (group by getType())
    public Map<String, Long> countFlowersByType(List<Gardener> gardeners) {
        return gardeners.stream()
                .flatMap(gardener -> gardener.getAssignedFlowers().stream())
                .collect(Collectors.groupingBy(
                        Flower::getName,
                        Collectors.counting()
                ));
    }

    // Collect unique care actions using your custom collector
    public Set<String> collectUniqueCareActions(List<Gardener> gardeners) {
        return gardeners.stream()
                .collect(new UniqueCareActionCollector());
    }

}
