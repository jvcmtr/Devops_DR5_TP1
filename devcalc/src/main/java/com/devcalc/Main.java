package com.devcalc;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {

        // codigo retirado e adaptado da documentação oficial
        // https://javalin.io/documentation
        Javalin app = Javalin.create().start(8000);

        app.get("/", ctx -> ctx.result("FUNCIONANDO "));
    }
}
