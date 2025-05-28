package com.devcalc;

import com.devcalc.CalculatorService.CalculatorService;
import com.devcalc.CalculatorService.Operations.DoubleOperations;
import com.devcalc.CalculatorService.Operations.IntegerOperations;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        // codigo retirado e adaptado da documentação oficial
        // https://javalin.io/documentation
        Javalin app = Javalin.create().start(8000);

        app.get("/", ctx -> {
            ctx.contentType("text/html");
            ctx.result(
                "<html> <body>"+
                "<h3> Endpoints : </h3>"+
                "<ul> <a href=\"/add?a=1&b=1\">Add 1 + 1</a><br> </ul> "+
                "<ul> <a href=\"/subtract?a=10&b=1\">Subtract 10 - 1</a><br> </ul>"+
                "<ul> <a href=\"/multiply?a=5&b=2\">Multiply 5 x 2</a><br> </ul> "+
                "<ul> <a href=\"/divide?a=10&b=2\">Divide 10 / 2</a><br> </ul> "+
                "</body></html>"
            );
        });
        
        app.get("/add", ctx -> {
            try {
                Integer a = Integer.valueOf( ctx.queryParam("a") );
                Integer b = Integer.valueOf( ctx.queryParam("b") );
                Integer result = CalculatorService.Calculate(a, b, IntegerOperations.ADD);
                ctx.result("" + result);

            } catch (NumberFormatException  e) {
                Double a = Double.valueOf( ctx.queryParam("a") );
                Double b = Double.valueOf( ctx.queryParam("b") );
                Double result = CalculatorService.Calculate(a, b, DoubleOperations.ADD);
                ctx.result("" + result);
            } catch (Exception e ){
                ctx.status(400);
                ctx.result("Could not parse required query parameters");
            }
        });


        app.get("/subtract", ctx -> {
            try {
                Integer a = Integer.valueOf( ctx.queryParam("a") );
                Integer b = Integer.valueOf( ctx.queryParam("b") );
                Integer result = CalculatorService.Calculate(a, b, IntegerOperations.SUBTRACT);
                ctx.result("" + result);

            } catch (NumberFormatException  e) {
                Double a = Double.valueOf( ctx.queryParam("a") );
                Double b = Double.valueOf( ctx.queryParam("b") );
                Double result = CalculatorService.Calculate(a, b, DoubleOperations.SUBTRACT);
                ctx.result("" + result);
            } catch (Exception e ){
                ctx.status(400);
                ctx.result("Could not parse required query parameters");
            }
        });

       app.get("/multiply", ctx -> {
            try {
                Integer a = Integer.valueOf( ctx.queryParam("a") );
                Integer b = Integer.valueOf( ctx.queryParam("b") );
                Integer result = CalculatorService.Calculate(a, b, IntegerOperations.MULTIPLY);
                ctx.result("" + result);

            } catch (NumberFormatException  e) {
                Double a = Double.valueOf( ctx.queryParam("a") );
                Double b = Double.valueOf( ctx.queryParam("b") );
                Double result = CalculatorService.Calculate(a, b, DoubleOperations.MULTIPLY);
                ctx.result("" + result);
            } catch (Exception e ){
                ctx.status(400);
                ctx.result("Could not parse required query parameters");
            }
        });

        app.get("/divide", ctx -> {
            try {
                Integer a = Integer.valueOf( ctx.queryParam("a") );
                Integer b = Integer.valueOf( ctx.queryParam("b") );
                Integer result = CalculatorService.Calculate(a, b, IntegerOperations.DIVIDE);
                ctx.result("" + result);

            } catch (NumberFormatException  e) {
                Double a = Double.valueOf( ctx.queryParam("a") );
                Double b = Double.valueOf( ctx.queryParam("b") );
                Double result = CalculatorService.Calculate(a, b, DoubleOperations.DIVIDE);
                ctx.result("" + result);
            } catch (ArithmeticException e){
                ctx.status(400);
                ctx.result("Cannot devide by zero");
            } catch (Exception e ){
                ctx.status(400);
                ctx.result("Could not parse required query parameters");
            }
        });
    }
}
