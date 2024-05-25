package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(value -> value
                        .subjects()
                        .stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(tuple -> new Tuple(tuple.name(), averageScore(Stream.of(tuple))))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(value -> value
                        .subjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::name, LinkedHashMap::new, Collectors
                                .averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(tuple -> new Tuple(tuple.name(), tuple
                        .subjects()
                        .stream()
                        .mapToDouble(Subject::score)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(value -> value
                        .subjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::name, LinkedHashMap::new, Collectors
                                .summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}
