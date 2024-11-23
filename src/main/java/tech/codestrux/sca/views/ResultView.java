package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

import java.util.Map;

/**
 * The main view contains a button and a click listener.
 */
@Route("result")
@PageTitle("Resultados")
@PreserveOnRefresh
public class ResultView extends VerticalLayout {

    @Autowired
    Prueba prueba;

    Map<Integer, String> respuestasCorrectas =  Map.ofEntries(
            Map.entry(1, "b) Confidencialidad"),
            Map.entry(2, "b) Usar más de un método de verificación para acceder al sistema"),
            Map.entry(3, "b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo"),
            Map.entry(4, "b) Falta de sanitización en la entrada del usuario"),
            Map.entry(  5, "b) Codificar correctamente las entradas del usuario al renderizarlas"),
            Map.entry( 6, "a) Control de acceso basado en roles (RBAC)"),
            Map.entry( 7, "b) Usar un algoritmo hash con sal (salted hashing)"),
            Map.entry( 8, "b) Un encabezado que especifica qué recursos pueden cargarse en una página web"),
            Map.entry(9, "b) Para minimizar la superficie de ataque"),
            Map.entry(10, "b) Documentarla y solucionarla lo antes posible"),
            Map.entry(11, "b) Implementar un sistema de revisión periódica para identificar amenazas y actividades sospechosas en tiempo real"),
            Map.entry(12,"b) ISO/IEC 27001"),
            Map.entry( 13, "a) Uso de cookies inseguras sin bandera HttpOnly"),
            Map.entry(14, "c) Ataque DDoS - Usar un balanceador de carga o WAF"),
            Map.entry(15, "b) Usar tokens únicos que se validen en cada solicitud")
    );


    Map<Integer, String> respuestasfirstuse = Map.ofEntries(
            Map.entry(1, "b) Confidencialidad"),
            Map.entry(2, "b) Usar más de un método de verificación para acceder al sistema"),
            Map.entry(3, "b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo"),
            Map.entry(4, "c) Uso incorrecto de permisos en la base de datos"),
            Map.entry(  5, "a) Usar HTTPS"),
            Map.entry( 6, "d) Implementación de tokens de sesión"),
            Map.entry( 7, "b) Usar un algoritmo hash con sal (salted hashing)"),
            Map.entry( 8, "c) Un protocolo para cifrar comunicaciones web"),
            Map.entry(9, "b) Para minimizar la superficie de ataque"),
            Map.entry(10, "b) Documentarla y solucionarla lo antes posible"),
            Map.entry(11, "b) Implementar un sistema de revisión periódica para identificar amenazas y actividades sospechosas en tiempo real"),
            Map.entry(12,"a) OWASP Top 10"),
            Map.entry( 13, "a) Uso de cookies inseguras sin bandera HttpOnly"),
            Map.entry(14, "b) Ataque de fuerza bruta - Implementar MFA"),
            Map.entry(15, "c) Encriptar los datos del formulario")
            );


    public ResultView(Prueba prueba) {

        // Obtener las respuestas seleccionadas desde el objeto 'Prueba'
        Map<Integer, String> respuestasSeleccionadas = prueba.getRespuestas(); // Asume que tienes este método
        Div resultado = result(respuestasSeleccionadas, "resultado");

        Div resultadofirst = result(respuestasfirstuse, "resultado2");

        add(new H3("Resultados de " + prueba.getNombre()));
        Button button = new Button("Finalizar", e -> {
            UI.getCurrent().navigate("");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);

        add(new H3("Actual"));
        add(resultado);
        add(new H3("Primer Uso"));
        add(resultadofirst);
        add(button);
        addClassName("wider-content");
    }


    private Div result(Map<Integer, String> respuestasSeleccionadas, String name) {
        // Crear un Div para mostrar el resultado
        Div resultado = new Div();
        resultado.addClassName("resultado");

        final int totalPreguntas = respuestasCorrectas.size();
        final int[] respuestasCorrectasCount = {0};

        // Verificar si hay respuestas seleccionadas
        if (respuestasSeleccionadas != null && !respuestasSeleccionadas.isEmpty()) {
            // Construir el texto con las respuestas seleccionadas y validación
            StringBuilder resultadoHtml = new StringBuilder("<b>Respuestas seleccionadas:</b><br>");
            respuestasSeleccionadas.forEach((pregunta, respuestaSeleccionada) -> {
                String respuestaCorrecta = respuestasCorrectas.get(pregunta);

                if (respuestaCorrecta != null) {
                    boolean esCorrecta = respuestaCorrecta.equals(respuestaSeleccionada);
                    if (esCorrecta) {
                        respuestasCorrectasCount[0]++;
                    }
                    resultadoHtml.append("Pregunta ").append(pregunta).append(": ")
                            .append(respuestaSeleccionada != null ? respuestaSeleccionada : "Sin respuesta")
                            .append(" - <b>").append(esCorrecta ? "Correcta" : "Incorrecta").append("</b><br>");
                } else {
                    resultadoHtml.append("Pregunta ").append(pregunta)
                            .append(": No definida en las respuestas correctas<br>");
                }
            });
            double nota = (double) respuestasCorrectasCount[0] / totalPreguntas * 100;
            resultadoHtml.append("<br><b>Nota final: </b>").append(String.format("%.2f", nota)).append("%<br>");
            // Establecer el contenido como HTML
            resultado.getElement().setProperty("innerHTML", resultadoHtml.toString());
        } else {
            resultado.setText("No hay resultados seleccionados aún.");
        }
        return  resultado;
    }

}
