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
@Route("group5")
@PageTitle("Sección 5")
@PreserveOnRefresh
public class Group5View extends VerticalLayout {
    @Autowired
    Prueba prueba;

    public Group5View(Prueba prueba) {
        add(new H2("Sección 5: Escenarios Prácticos"));
        /* Pregunta 1 */
        add(new H4("13. Un usuario reporta que su sesión fue robada en tu aplicación. ¿Cuál podría ser la causa más probable?"));
        RadioButtonGroup<String> radioGroupQ13 = new RadioButtonGroup<>();
        radioGroupQ13.setItems("a) Uso de cookies inseguras sin bandera HttpOnly",
                "b) Un ataque DoS al servidor",
                "c) Contraseñas reutilizadas en otros sistemas",
                "d) Configuración incorrecta de DNS");
        radioGroupQ13.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        radioGroupQ13.addClassName("vertical-radio-group");
        add(radioGroupQ13);
        /* Pregunta 2 */
        add(new H4("14. Has encontrado que un atacante intenta enviar múltiples solicitudes al servidor para forzar la caída del sistema. ¿Cómo se llama este tipo de ataque y qué medida puede prevenirlo?"));
        RadioButtonGroup<String> radioGroupQ14 = new RadioButtonGroup<>();
        radioGroupQ14.setItems("a) Inyección SQL - Usar consultas preparadas",
                "b) Ataque de fuerza bruta - Implementar MFA",
                "c) Ataque DDoS - Usar un balanceador de carga o WAF",
                "d) Ataque MITM - Implementar TLS");
        radioGroupQ14.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ14);
        /* Pregunta 3 */
        add(new H4("15. Al auditar el código de un formulario de inicio de sesión, observas que no está implementando un mecanismo anti-CSRF. ¿Qué recomendarías?"));
        RadioButtonGroup<String> radioGroupQ15 = new RadioButtonGroup<>();
        radioGroupQ15.setItems("a) Añadir autenticación multifactor",
                "b) Usar tokens únicos que se validen en cada solicitud",
                "c) Encriptar los datos del formulario",
                "d) Permitir inicios de sesión solo desde dispositivos conocidos");
        radioGroupQ15.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ15);
        if (prueba != null) {
            radioGroupQ13.setValue(prueba.getRespuestas().get(13));
            radioGroupQ14.setValue(prueba.getRespuestas().get(14));
            radioGroupQ15.setValue(prueba.getRespuestas().get(15));
        }
        Button button = new Button("finalizar", e -> {
            if (prueba != null) {
                prueba.getRespuestas().put(13, radioGroupQ13.getValue());
                prueba.getRespuestas().put(14, radioGroupQ14.getValue());
                prueba.getRespuestas().put(15, radioGroupQ15.getValue());
            }
            UI.getCurrent().navigate("result");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        add(button);
        addClassName("wider-content");
    }
}
