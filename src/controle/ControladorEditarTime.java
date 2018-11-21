package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelo.Time;

public class ControladorEditarTime implements Initializable{

    Time t = new Time();
    
    @FXML
    private JFXTextField textNomeT;

    @FXML
    private JFXButton btCancelarEdit, btEdit;

    @FXML
    private JFXDatePicker dtFund;

    @FXML
    private void cancelarEdit() {
        ControladorPrincipal.controlador.configuracao();
    }

    @FXML
    private void editarTime() {
        
        /*nome = textNomeT.getText();

        Date d = Date.from(dtFund.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        dataFund = formatador.format(d);
        
        t.setNome(nome);
        t.setDataFundacao(dataFund);*/
        
        ControladorPrincipal.controlador.configuracao();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
