package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PageTitle("SCA")
@PreserveOnRefresh
public class MainView extends VerticalLayout {

    @Autowired
    Prueba prueba;

    public MainView(Prueba prueba) {
        add(new H1("SCA"));
        add(new Paragraph("ETC - Iniciemos con el test de ciberseguridad ..."));
        TextField nombre = new TextField("Cuál es tu nombre?");
        if (prueba != null) {
            nombre.setValue(prueba.getNombre());
        }
        Button button = new Button("Iniciar", e -> {
            if (prueba != null) {
                prueba.setNombre(nombre.getValue());
            }
            UI.getCurrent().navigate("group1");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        addClassName("wider-content");
        add(nombre, button);
    }
}
