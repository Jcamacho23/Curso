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
@Route("group1")
@PageTitle("Sección 1")
@PreserveOnRefresh
public class Group1View extends VerticalLayout {
    @Autowired
    Prueba prueba;

    public Group1View(Prueba prueba) {
        add(new H2("Sección 1: Principios Fundamentales de Ciberseguridad"));
        /* Pregunta 1 */
        add(new H4("1. ¿Qué principio de seguridad se enfoca en garantizar que solo usuarios autorizados accedan a" +
                " los datos sensibles?"));
        RadioButtonGroup<String> radioGroupQ1 = new RadioButtonGroup<>();
        radioGroupQ1.setItems("a) Disponibilidad", "b) Confidencialidad", "c) Integridad", "d) Autenticación");
        radioGroupQ1.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        radioGroupQ1.addClassName("vertical-radio-group");
        add(radioGroupQ1);
        /* Pregunta 2 */
        add(new H4("2. ¿Qué es la autenticación multifactor (MFA)?"));
        RadioButtonGroup<String> radioGroupQ2 = new RadioButtonGroup<>();
        radioGroupQ2.setItems("a) Verificar el correo electrónico del usuario",
                "b) Usar más de un método de verificación para acceder al sistema",
                "c) Implementar contraseñas más largas",
                "d) Activar la autenticación automática");
        radioGroupQ2.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ2);
        /* Pregunta 3 */
        add(new H4("3. Seleccione la opción que describe correctamente el principio de \"privilegios mínimos\":"));
        RadioButtonGroup<String> radioGroupQ3 = new RadioButtonGroup<>();
        radioGroupQ3.setItems("a) Dar acceso completo a todos los usuarios del sistema",
                "b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo",
                "c) Permitir a los usuarios administrativos desactivar los controles de seguridad",
                "d) Proporcionar acceso temporal sin registros");
        radioGroupQ3.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ3);
        if (prueba != null) {
            radioGroupQ1.setValue(prueba.getRespuestas().get(1));
            radioGroupQ2.setValue(prueba.getRespuestas().get(2));
            radioGroupQ3.setValue(prueba.getRespuestas().get(3));
        }
        Button button = new Button("siguiente", e -> {
            if (prueba != null) {
                prueba.getRespuestas().put(1, radioGroupQ1.getValue());
                prueba.getRespuestas().put(2, radioGroupQ2.getValue());
                prueba.getRespuestas().put(3, radioGroupQ3.getValue());
            }
            UI.getCurrent().navigate("group2");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        add(button);
        addClassName("wider-content");
    }
}
