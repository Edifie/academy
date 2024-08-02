package com.ctw.workstation.helloacademy;

public class HelloAcademy {

    public String sayHello(String name) {
        if (name != null) {
            return "Hello " + name;
        } else {
            return "Hello";
        }
    }

    // when to ignore arguments in the parameters
//    mockito.anyList, or mockito.any(sth)
}
