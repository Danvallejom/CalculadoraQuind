package com.quind.calculadora.controlador;

import com.quind.calculadora.modelo.Resultados;
import org.apache.tomcat.util.compat.JrePlatform;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController

public class ControladorCalculadora {


    //SUMA
    @RequestMapping(value = "/suma", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resultados suma(@RequestParam(name = "op1", required = false, defaultValue = "0") String op1,
                           @RequestParam(name = "op2", required = false, defaultValue = "0") String op2){

        Resultados exported = new Resultados();

        try {
            char target;
            op1 = op1.replace(",",".");
            float castOp1 = Float.parseFloat(op1);
            float castOp2 = Float.parseFloat(op2);

            float internalResultados = castOp1 + castOp2;

            exported.setResultados(internalResultados);
            exported.setEstado("OK");

        }

        catch (NumberFormatException ex){
            exported.setEstado("Error: Uno de los operadores no es numérico");
        }


        return exported;


    }

    //RESTA
    @RequestMapping(value = "/resta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resultados resta(@RequestParam(name = "op1", required = false, defaultValue = "0") String op1,
                            @RequestParam(name = "op2", required = false, defaultValue = "0") String op2) {
        Resultados exported = new Resultados();

        try {
            float castOp1 = Float.parseFloat(op1.replace(",", "."));
            float castOp2 = Float.parseFloat(op2.replace(",", "."));

            float internalResultados = castOp1 - castOp2;

            exported.setResultados(internalResultados);
            exported.setEstado("OK");
        } catch (NumberFormatException ex) {
            exported.setEstado("Error: Uno de los operadores no es numérico");
        }

        return exported;
    }

    //MULTIPLICACION
    @RequestMapping(value = "/multiplicacion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resultados multiplicacion(@RequestParam(name = "op1", required = false, defaultValue = "0") String op1,
                                     @RequestParam(name = "op2", required = false, defaultValue = "0") String op2) {
        Resultados exported = new Resultados();

        try {
            float castOp1 = Float.parseFloat(op1.replace(",", "."));
            float castOp2 = Float.parseFloat(op2.replace(",", "."));

            float internalResultados = castOp1 * castOp2;

            exported.setResultados(internalResultados);
            exported.setEstado("OK");
        } catch (NumberFormatException ex) {
            exported.setEstado("Error: Uno de los operadores no es numérico");
        }

        return exported;
    }


    //DIVISION VALIDANDO LA DIVISION POR CERO
    @RequestMapping(value = "/division", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resultados division(@RequestParam(name = "op1", required = false, defaultValue = "0") String op1,
                               @RequestParam(name = "op2", required = false, defaultValue = "0") String op2) {
        Resultados exported = new Resultados();

        try {
            float castOp1 = Float.parseFloat(op1.replace(",", "."));
            float castOp2 = Float.parseFloat(op2.replace(",", "."));

            if (castOp2 != 0) {
                float internalResultados = castOp1 / castOp2;

                exported.setResultados(internalResultados);
                exported.setEstado("OK");
            } else {
                exported.setEstado("Error: La división por cero no permitida");
            }
        } catch (NumberFormatException ex) {
            exported.setEstado("Error: Uno de los operadores no es numérico");
        }

        return exported;
    }



}
