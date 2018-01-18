package session;

import entities.InstalacionCab;
import entities.InstalacionDet;
import java.util.List;
import bean.InstalacionCabFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "instalacionCabController")
@ViewScoped
public class InstalacionCabController extends AbstractController<InstalacionCab> {

    public InstalacionCabController() {
        // Inform the Abstract parent controller of the concrete InstalacionCab Entity
        super(InstalacionCab.class);
    }

}
