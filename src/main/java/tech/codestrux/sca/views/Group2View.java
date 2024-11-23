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
@Route("group2")
@PageTitle("Sección 2")
@PreserveOnRefresh
public class Group2View extends VerticalLayout {
    @Autowired
    Prueba prueba;

    public Group2View(Prueba prueba) {
        add(new H2("Sección 2: Seguridad en el Desarrollo Web"));
        /* Pregunta 1 */
        add(new H4("4. ¿Cuál es la causa principal de una vulnerabilidad de inyección SQL?"));
        RadioButtonGroup<String> radioGroupQ4 = new RadioButtonGroup<>();
        radioGroupQ4.setItems("a) Uso de contraseñas débiles",
                "b) Falta de sanitización en la entrada del usuario",
                "c) Uso incorrecto de permisos en la base de datos",
                "d) Bases de datos mal configuradas");
        radioGroupQ4.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        radioGroupQ4.addClassName("vertical-radio-group");
        add(radioGroupQ4);
        /* Pregunta 2 */
        add(new H4("5. ¿Qué medida es más efectiva para prevenir ataques XSS (Cross-Site Scripting)?"));
        RadioButtonGroup<String> radioGroupQ5 = new RadioButtonGroup<>();
        radioGroupQ5.setItems("a) Usar HTTPS",
                "b) Codificar correctamente las entradas del usuario al renderizarlas",
                "c) Implementar contraseñas más complejas",
                "d) Aumentar la capacidad del servidor");
        radioGroupQ5.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ5);
        /* Pregunta 3 */
        add(new H4("6. En una aplicación basada en roles, ¿qué técnica asegura que un usuario solo pueda acceder a recursos que le correspondan?"));
        RadioButtonGroup<String> radioGroupQ6 = new RadioButtonGroup<>();
        radioGroupQ6.setItems("a) Control de acceso basado en roles (RBAC)",
                "b) Configuración de cortafuegos",
                "c) Uso de cifrado en la base de datos",
                "d) Implementación de tokens de sesión");
        radioGroupQ6.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ6);
        if (prueba != null) {
            radioGroupQ4.setValue(prueba.getRespuestas().get(4));
            radioGroupQ5.setValue(prueba.getRespuestas().get(5));
            radioGroupQ6.setValue(prueba.getRespuestas().get(6));
        }
        Button button = new Button("siguiente", e -> {
            if (prueba != null) {
                prueba.getRespuestas().put(4, radioGroupQ4.getValue());
                prueba.getRespuestas().put(5, radioGroupQ5.getValue());
                prueba.getRespuestas().put(6, radioGroupQ6.getValue());
            }
            UI.getCurrent().navigate("group3");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        add(button);
        addClassName("wider-content");
    }
}
