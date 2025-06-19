package com.flowers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


//A : a Map<String, Set<String>> where key = gardener name, value = set of unique actions
//R: Combine all sets into a single Set<String> of all unique care actions
public class UniqueCareActionCollector implements Collector<Gardener, Map<String, Set<String>>, Set<String>> {

    @Override
    public Supplier<Map<String, Set<String>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Set<String>>, Gardener> accumulator() {
        return (map, gardener) -> {
            // Step 1: Get the care actions for this gardener
            Set<String> uniqueActions =
                    gardener.getAssignedFlowers().stream()
                            .flatMap(flower -> flower.getCareActions().stream())
                            .collect(Collectors.toSet());

            // Step 2: Merge actions into the result map
            map.merge(gardener.getName(), uniqueActions, (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            });
        };
    }

    @Override
    public BinaryOperator<Map<String, Set<String>>> combiner() {
        return (map1, map2) -> {
            map2.forEach((gardenerName, actions) ->
                    map1.merge(gardenerName, actions, (existing, newSet) -> {
                        existing.addAll(newSet);
                        return existing;
                    })
            );
            return map1;
        };
    }

    @Override
    public Function<Map<String, Set<String>>, Set<String>> finisher() {
        return map -> map.values().stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());  // Union of all gardeners' actions;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet(); // Not IDENTITY_FINISH
    }
}
