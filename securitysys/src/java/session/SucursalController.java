package session;

import entities.Sucursal;
import entities.Promocion;
import entities.CuentaCliente;
import entities.AperturaCierreCaja;
import entities.Contrato;
import entities.Presupuesto;
import entities.OrdenTrabajo;
import entities.Reclamo;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.SerieComprobante;
import entities.NotaRemisionVenta;
import entities.Diagnostico;
import entities.Solicitud;
import java.util.List;
import bean.SucursalFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "sucursalController")
@ViewScoped
public class SucursalController extends AbstractController<Sucursal> {

    public SucursalController() {
        // Inform the Abstract parent controller of the concrete Sucursal Entity
        super(Sucursal.class);
    }

}
