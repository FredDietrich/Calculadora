package com.dietrich.calc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcController {
    @GetMapping("/")
    public String index() {
        return """
                    <body>
                    <form>
                        <input type='number' placeholder='Primeiro Numero' id='primeiro'>
                        <input type='number' placeholder='Segundo Numero' id='segundo'>
                        <input type='text' placeholder='operador' id='operador'>
                        <button id='calcula'>Calcular</button>
                    </form>
                    <div id='resultado'></div>
                    <script src='https://code.jquery.com/jquery-3.6.0.min.js' integrity='sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=' crossorigin='anonymous'></script>
                    <script>
                        $(document).ready(function() {
                            $('#calcula').click(()=>{
                                var settings = {
                                    'url': `http://localhost:8080/api?operator=${$('#operador').val()}&firstNumber=${$('#primeiro').val()}&secondNumber=${$('#segundo').val()}`,
                                    'method': 'POST',
                                    'timeout': 0,
                                };
                                $.ajax(settings).done(response => {
                                alert(response.result)
                                });
                            })
                        });
                    </script>
                </body>
                                                                """;
    }

    @PostMapping("/api")
    public calculator calculator(@RequestParam(value = "operator", defaultValue = "+") String operator,
            @RequestParam(value = "firstNumber", defaultValue = "1.0") Double firstNumber,
            @RequestParam(value = "secondNumber", defaultValue = "1.0") Double secondNumber) {
        return new calculator(operator, firstNumber, secondNumber);
    }
}
