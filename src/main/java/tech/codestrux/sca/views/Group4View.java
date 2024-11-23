package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

/**
 * The main view contains a button and a click listener.
 */
@Route("group4")
@PageTitle("Sección 4")
@PreserveOnRefresh
public class Group4View extends VerticalLayout {
    @Autowired
    Prueba prueba;

    public Group4View(Prueba prueba) {
        add(new H2("Sección 4: Respuesta a Incidentes y Cumplimiento"));
        /* Pregunta 1 */
        add(new H4("10. ¿Qué acción se considera una buena práctica después de detectar una vulnerabilidad en tu aplicación?"));
        RadioButtonGroup<String> radioGroupQ10 = new RadioButtonGroup<>();
        radioGroupQ10.setItems("a) Ignorarla si no ha sido explotada",
                "b) Documentarla y solucionarla lo antes posible",
                "c) Comunicarla únicamente al equipo de desarrollo",
                "d) Deshabilitar temporalmente la aplicación");
        radioGroupQ10.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        radioGroupQ10.addClassName("vertical-radio-group");
        add(radioGroupQ10);
        /* Pregunta 2 */
        add(new H4("11. ¿Qué es el monitoreo continuo en ciberseguridad?"));
        RadioButtonGroup<String> radioGroupQ11 = new RadioButtonGroup<>();
        radioGroupQ11.setItems("a) Actualizar sistemas una vez al año",
                "b) Implementar un sistema de revisión periódica para identificar amenazas y actividades " +
                        "sospechosas en tiempo real",
                "c) Monitorear únicamente los accesos administrativos",
                "d) Realizar auditorías de código esporádicamente");
        radioGroupQ11.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ11);
        /* Pregunta 3 */
        add(new H4("12. ¿Qué estándar es reconocido para gestionar riesgos en seguridad de la información?"));
        RadioButtonGroup<String> radioGroupQ12 = new RadioButtonGroup<>();
        radioGroupQ12.setItems("a) OWASP Top 10",
                "b) ISO/IEC 27001",
                "c) CIS Controls",
                "d) GDPR");
        radioGroupQ12.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ12);
        if (prueba != null) {
            radioGroupQ10.setValue(prueba.getRespuestas().get(10));
            radioGroupQ11.setValue(prueba.getRespuestas().get(11));
            radioGroupQ12.setValue(prueba.getRespuestas().get(12));
        }
        Button button = new Button("siguiente", e -> {
            if (prueba != null) {
                prueba.getRespuestas().put(10, radioGroupQ10.getValue());
                prueba.getRespuestas().put(11, radioGroupQ11.getValue());
                prueba.getRespuestas().put(12, radioGroupQ12.getValue());
            }
            UI.getCurrent().navigate("group5");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        add(button);
        addClassName("wider-content");
    }
}
