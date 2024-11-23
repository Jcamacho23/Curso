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
@Route("group3")
@PageTitle("Sección 3")
@PreserveOnRefresh
public class Group3View extends VerticalLayout {
    @Autowired
    Prueba prueba;

    public Group3View(Prueba prueba) {
        add(new H2("Sección 3: Infraestructura y Configuración Segura"));
        /* Pregunta 1 */
        add(new H4("7. ¿Cuál es la mejor práctica al almacenar contraseñas en una base de datos?"));
        RadioButtonGroup<String> radioGroupQ7 = new RadioButtonGroup<>();
        radioGroupQ7.setItems("a) Almacenar contraseñas en texto plano",
                "b) Usar un algoritmo hash con sal (salted hashing)",
                "c) Usar un cifrado reversible para poder recuperar la contraseña",
                "d) Almacenar contraseñas en un archivo de texto externo");
        radioGroupQ7.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        radioGroupQ7.addClassName("vertical-radio-group");
        add(radioGroupQ7);
        /* Pregunta 2 */
        add(new H4("8. ¿Qué es el encabezado HTTP Content-Security-Policy (CSP)?"));
        RadioButtonGroup<String> radioGroupQ8 = new RadioButtonGroup<>();
        radioGroupQ8.setItems("a) Un mecanismo para proteger contra ataques DoS",
                "b) Un encabezado que especifica qué recursos pueden cargarse en una página web",
                "c) Un protocolo para cifrar comunicaciones web",
                "d) Una configuración de firewall para servidores web");
        radioGroupQ8.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ8);
        /* Pregunta 3 */
        add(new H4("9. ¿Por qué es importante deshabilitar servicios o funcionalidades que no se utilizan en un servidor " +
                "web?"));
        RadioButtonGroup<String> radioGroupQ9 = new RadioButtonGroup<>();
        radioGroupQ9.setItems("a) Para mejorar el rendimiento del servidor",
                "b) Para minimizar la superficie de ataque",
                "c) Para reducir costos de operación",
                "d) Para facilitar las actualizaciones de software");
        radioGroupQ9.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        add(radioGroupQ9);
        if (prueba != null) {
            radioGroupQ7.setValue(prueba.getRespuestas().get(7));
            radioGroupQ8.setValue(prueba.getRespuestas().get(8));
            radioGroupQ9.setValue(prueba.getRespuestas().get(9));
        }
        Button button = new Button("siguiente", e -> {
            if (prueba != null) {
                prueba.getRespuestas().put(7, radioGroupQ7.getValue());
                prueba.getRespuestas().put(8, radioGroupQ8.getValue());
                prueba.getRespuestas().put(9, radioGroupQ9.getValue());
            }
            UI.getCurrent().navigate("group4");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        add(button);
        addClassName("wider-content");
    }
}
