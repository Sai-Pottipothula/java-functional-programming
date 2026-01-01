package com.java.lambda.streamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsBasicsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        //void forEach(Consumer<? super T> action)
        numbers.stream()
                .forEach(e-> System.out.println(e));

        //Stream<T> filter(Predicate<? super T> predicate)
        numbers.stream()
                .filter(e->e%2==0)
                .forEach(e-> System.out.println(e));

        //<R> Stream<R> map(Function<? super T,? extends R> mapper)
        numbers.stream()
                .map(e->e*e)
                .forEach(e-> System.out.println(e));

        numbers.stream()
                .map(e->List.of(e*2, e*3, e*4))
                .forEach(e-> System.out.println(e));

        //<R> Stream<R> flatmap(Function<? super T,? extends Stream<? extends R>> mapper)
        numbers.stream()
                .flatMap(e->List.of(e*2, e*3, e*4).stream())
                .forEach(e-> System.out.println(e));

        numbers.stream()
                .flatMap(e-> Stream.of(e*2, e*3, e*4))
                .forEach(e-> System.out.println(e));

        //T reduce(T identity, BinaryOperations<T> accumulator)
        System.out.println(
                numbers.stream()
                .reduce(0, (e, carry) -> e+carry));
        //                                1     0               1
        //                                2     1               3
        //                                3     3               6

        //combining filter, map, reduce
        System.out.println(
        numbers.stream()
                .filter(e->e%2==0)
                .map(e->e*e)
                .reduce(1, (e, carry)->e*carry));

        //IntStream mapToInt(ToIntFunction<? super T> mapper)
        //DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
        //LongStream mapToLong(ToLongFunction<? super T> mapper)
        System.out.println(
        numbers.stream()
                .filter(e->e%2==0)
                .mapToInt(e->e*e)
                .sum());

        //Stream<T> peak(Consumer<? super T> action)
        System.out.println(
                numbers.stream()
                .filter(e->e%2==0)
                        .peek(e-> System.out.println(e))
                .mapToInt(e->e*e)
                .sum());

        //Object[] toArray()
        Object[] obj = numbers.stream()
                .filter(e-> e%2==0)
                .map(e->e*2)
                .toArray();

        //default List<T> toList()
        List<Integer> list = numbers.stream()
                .filter(e-> e%2==0)
                .map(e->e*2)
                .toList();

        //<R,A> R collect(Collector<? super T,A,R> collector)
        Set<Integer> collect = numbers.stream()
                .filter(e-> e%2==0)
                .map(e->e*2)
                .collect(Collectors.toSet());

        //allMatch, anyMatch, noneMatch
        //boolean allMatch(Predicate<? super T> predicate)
        //boolean anyMatch(Predicate<? super T> predicate)
        //boolean noneMatch(Predicate<? super T> predicate)
        numbers.stream()
                .allMatch(e->e%2==0); //False

        //long count
        numbers.stream()
                .filter(e->e>4)
                .filter(e->e%2!=0)
                .count();

        //Stream<T> distinct()
        numbers.stream()
                .distinct()
                .forEach(e-> System.out.println(e));

        //Optional<T> findAny()
        //Optional<T> findFirst()
        numbers.stream()
                .filter(e-> e%2==0)
                .map(e->e*e)
                .findFirst();

        //Stream<T> skip(long n)
        //Stream<T> limit(long maxSize)
        numbers.stream()
                .skip(3)
                .limit(6)
                .forEach(e-> System.out.println(e));

        //Stream<T> sorted()
        //Stream<T> sorted(comparator<? super T> comparator)
        numbers.stream()
                .sorted((e1,e2)-> e2-e1)
                .forEach(e-> System.out.println(e));
    }
}
