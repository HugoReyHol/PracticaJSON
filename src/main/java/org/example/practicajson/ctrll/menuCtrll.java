package org.example.practicajson.ctrll;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.practicajson.model.Pelicula;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class menuCtrll {
    @FXML
    private TextField salidaTitulo, salidaFecha, salidaGenero, salidaDirector;

    @FXML
    private ListView<Pelicula> listaPeliculas;

    private final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private ObservableList<Pelicula> peliculas = FXCollections.observableArrayList();


    public void onImportar(ActionEvent actionEvent) throws IOException {
        ArrayList<Pelicula> p = JSON_MAPPER.readValue(new File("src/main/resources/json/peliculas.json"),
                JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));

        peliculas.addAll(p);

        listaPeliculas.setItems(peliculas);

    }


    public void onClick(MouseEvent mouseEvent) {
        Pelicula p = listaPeliculas.getSelectionModel().getSelectedItem();

        salidaDirector.setText(p.getDirector());
        salidaFecha.setText(p.getFecha());
        salidaGenero.setText(p.getGenero());
        salidaTitulo.setText(p.getTitulo());

    }
}