package com.learn.lambdafunc;

import java.util.function.Function;

public class InnerClass {
    //Implement instance of Function Interface using anonymous inner class in java 7
    Function<Object, String> f = new Function<Object, String>() {
        @Override
        public String apply(Object obj) {
            return obj.toString();
        }
    };
}
