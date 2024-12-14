package com.learn.lambdafunc;

import java.util.function.Function;

public class Lambda {
    //Implement instance of Function Interface using lambda expression in java 8
    Function<Object, String> f = (obj) -> obj.toString();

}
