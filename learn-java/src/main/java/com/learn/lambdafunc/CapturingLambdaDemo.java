package com.learn.lambdafunc;

import java.util.List;
import java.util.stream.Collectors;

public class CapturingLambdaDemo {
    List<Integer> calculate(List<Integer> list, int number) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * number)
                .collect(Collectors.toList());
    }
}
