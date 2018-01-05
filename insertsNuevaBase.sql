
CREATE SEQUENCE public.motivo_nota_debi_id_motivo_nota_seq;

CREATE TABLE public.motivo_nota_debi (
                id_motivo_nota INTEGER NOT NULL DEFAULT nextval('public.motivo_nota_debi_id_motivo_nota_seq'),
                desc_motivo_nota VARCHAR(60) NOT NULL,
                tipo_nota VARCHAR(60) NOT NULL,
                CONSTRAINT motivo_nota_pk PRIMARY KEY (id_motivo_nota)
);


ALTER SEQUENCE public.motivo_nota_debi_id_motivo_nota_seq OWNED BY public.motivo_nota_debi.id_motivo_nota;

CREATE SEQUENCE public.entidad_emisora_id_entidad_emisora_seq_1;

CREATE TABLE public.entidad_emisora (
                id_entidad_emisora INTEGER NOT NULL DEFAULT nextval('public.entidad_emisora_id_entidad_emisora_seq_1'),
                desc_entidad_emisora VARCHAR(60) NOT NULL,
                ruc_entidad_emisora VARCHAR(50) NOT NULL,
                dir_entidad_emisora VARCHAR(100) NOT NULL,
                tel_entidad_emisora VARCHAR(60) NOT NULL,
                CONSTRAINT entidad_emisora_pk PRIMARY KEY (id_entidad_emisora)
);


ALTER SEQUENCE public.entidad_emisora_id_entidad_emisora_seq_1 OWNED BY public.entidad_emisora.id_entidad_emisora;

CREATE SEQUENCE public.tipo_tarjeta_id_tipo_tarjeta_seq_1;

CREATE TABLE public.tipo_tarjeta (
                id_tipo_tarjeta INTEGER NOT NULL DEFAULT nextval('public.tipo_tarjeta_id_tipo_tarjeta_seq_1'),
                desc_tipo_tarjeta VARCHAR(60) NOT NULL,
                CONSTRAINT tipo_tarjeta_pk PRIMARY KEY (id_tipo_tarjeta)
);


ALTER SEQUENCE public.tipo_tarjeta_id_tipo_tarjeta_seq_1 OWNED BY public.tipo_tarjeta.id_tipo_tarjeta;

CREATE SEQUENCE public.marca_tarjeta_id_marca_tarjeta_seq_1;

CREATE TABLE public.marca_tarjeta (
                id_marca_tarjeta INTEGER NOT NULL DEFAULT nextval('public.marca_tarjeta_id_marca_tarjeta_seq_1'),
                desc_marca_tarjeta VARCHAR(60) NOT NULL,
                CONSTRAINT marca_tarjeta_pk PRIMARY KEY (id_marca_tarjeta)
);


ALTER SEQUENCE public.marca_tarjeta_id_marca_tarjeta_seq_1 OWNED BY public.marca_tarjeta.id_marca_tarjeta;

CREATE SEQUENCE public.tarjeta_id_tarjeta_seq;

CREATE TABLE public.tarjeta (
                id_tarjeta INTEGER NOT NULL DEFAULT nextval('public.tarjeta_id_tarjeta_seq'),
                desc_tarjeta VARCHAR(60) NOT NULL,
                nro_tarjeta VARCHAR(60) NOT NULL,
                id_entidad_emisora INTEGER NOT NULL,
                id_tipo_tarjeta INTEGER NOT NULL,
                id_marca_tarjeta INTEGER NOT NULL,
                CONSTRAINT tarjeta_pk PRIMARY KEY (id_tarjeta)
);


ALTER SEQUENCE public.tarjeta_id_tarjeta_seq OWNED BY public.tarjeta.id_tarjeta;

CREATE SEQUENCE public.banco_id_banco_seq;

CREATE TABLE public.banco (
                id_banco INTEGER NOT NULL DEFAULT nextval('public.banco_id_banco_seq'),
                desc_banco VARCHAR(60) NOT NULL,
                ruc_banco VARCHAR(50) NOT NULL,
                dir_banco VARCHAR(100) NOT NULL,
                tel_banco VARCHAR(50) NOT NULL,
                CONSTRAINT banco_pk PRIMARY KEY (id_banco)
);


ALTER SEQUENCE public.banco_id_banco_seq OWNED BY public.banco.id_banco;

CREATE TABLE public.forma_cobro (
                id_forma_cobro INTEGER NOT NULL,
                descripcion VARCHAR(50) NOT NULL,
                CONSTRAINT forma_cobro_pk PRIMARY KEY (id_forma_cobro)
);


CREATE SEQUENCE public.valor_id_valor_seq;

CREATE TABLE public.valor (
                id_valor INTEGER NOT NULL DEFAULT nextval('public.valor_id_valor_seq'),
                descripcion VARCHAR(50) NOT NULL,
                CONSTRAINT valor_pk PRIMARY KEY (id_valor)
);


ALTER SEQUENCE public.valor_id_valor_seq OWNED BY public.valor.id_valor;

CREATE SEQUENCE public.tipo_comprobante_id_tipo_comprobante_seq;

CREATE TABLE public.tipo_comprobante (
                id_tipo_comprobante INTEGER NOT NULL DEFAULT nextval('public.tipo_comprobante_id_tipo_comprobante_seq'),
                descripcion VARCHAR(20) NOT NULL,
                prefijo VARCHAR(5) NOT NULL,
                CONSTRAINT tipo_comprobante_pk PRIMARY KEY (id_tipo_comprobante)
);


ALTER SEQUENCE public.tipo_comprobante_id_tipo_comprobante_seq OWNED BY public.tipo_comprobante.id_tipo_comprobante;

CREATE TABLE public.timbrado (
                id_timbrado INTEGER NOT NULL,
                id_tipo_comprobante INTEGER NOT NULL,
                fecha_desde DATE NOT NULL,
                fecha_hasta DATE NOT NULL,
                nro_desde INTEGER NOT NULL,
                nro_hasta INTEGER NOT NULL,
                ultimo_nro INTEGER NOT NULL,
                nro_timbrado INTEGER NOT NULL,
                CONSTRAINT timbrado_pk PRIMARY KEY (id_timbrado)
);


CREATE SEQUENCE public.caja_id_caja_seq;

CREATE TABLE public.caja (
                id_caja INTEGER NOT NULL DEFAULT nextval('public.caja_id_caja_seq'),
                descripcion VARCHAR(60) NOT NULL,
                CONSTRAINT caja_pk PRIMARY KEY (id_caja)
);


ALTER SEQUENCE public.caja_id_caja_seq OWNED BY public.caja.id_caja;

CREATE SEQUENCE public.moneda_id_moneda_seq;

CREATE TABLE public.moneda (
                id_moneda INTEGER NOT NULL DEFAULT nextval('public.moneda_id_moneda_seq'),
                descripcion VARCHAR(30) NOT NULL,
                abreviatura VARCHAR(3) NOT NULL,
                CONSTRAINT id_moneda PRIMARY KEY (id_moneda)
);


ALTER SEQUENCE public.moneda_id_moneda_seq OWNED BY public.moneda.id_moneda;

CREATE SEQUENCE public.descuento_id_descuento_seq;

CREATE TABLE public.descuento (
                id_descuento INTEGER NOT NULL DEFAULT nextval('public.descuento_id_descuento_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                descripcion_desc VARCHAR(100) NOT NULL,
                CONSTRAINT id_descuento PRIMARY KEY (id_descuento)
);


ALTER SEQUENCE public.descuento_id_descuento_seq OWNED BY public.descuento.id_descuento;

CREATE TABLE public.descuento_det (
                id_descuento INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                porcentaje_desc INTEGER NOT NULL,
                CONSTRAINT id_descuento PRIMARY KEY (id_descuento, id_secuencia)
);


CREATE SEQUENCE public.tecnico_id_tecnico_seq;

CREATE TABLE public.tecnico (
                id_tecnico INTEGER NOT NULL DEFAULT nextval('public.tecnico_id_tecnico_seq'),
                nombre VARCHAR(50) NOT NULL,
                nro_documento INTEGER NOT NULL,
                CONSTRAINT id_tecnico PRIMARY KEY (id_tecnico)
);


ALTER SEQUENCE public.tecnico_id_tecnico_seq OWNED BY public.tecnico.id_tecnico;

CREATE SEQUENCE public.ruta_id_ruta_seq;

CREATE TABLE public.ruta (
                id_ruta INTEGER NOT NULL DEFAULT nextval('public.ruta_id_ruta_seq'),
                id_zona INTEGER NOT NULL,
                dias_recorridos VARCHAR(50) NOT NULL,
                CONSTRAINT id_ruta PRIMARY KEY (id_ruta)
);


ALTER SEQUENCE public.ruta_id_ruta_seq OWNED BY public.ruta.id_ruta;

CREATE SEQUENCE public.tipo_cuadrilla_id_tipo_cuadrilla_seq;

CREATE TABLE public.tipo_cuadrilla (
                id_tipo_cuadrilla INTEGER NOT NULL DEFAULT nextval('public.tipo_cuadrilla_id_tipo_cuadrilla_seq'),
                descripcion VARCHAR(100) NOT NULL,
                CONSTRAINT id_tipo_cuadrilla PRIMARY KEY (id_tipo_cuadrilla)
);


ALTER SEQUENCE public.tipo_cuadrilla_id_tipo_cuadrilla_seq OWNED BY public.tipo_cuadrilla.id_tipo_cuadrilla;

CREATE SEQUENCE public.marca_id_marca_seq;

CREATE TABLE public.marca (
                id_marca INTEGER NOT NULL DEFAULT nextval('public.marca_id_marca_seq'),
                descripcion VARCHAR(60) NOT NULL,
                CONSTRAINT id_marca PRIMARY KEY (id_marca)
);


ALTER SEQUENCE public.marca_id_marca_seq OWNED BY public.marca.id_marca;

CREATE SEQUENCE public.tipo_movil_id_tipo_movil_seq;

CREATE TABLE public.tipo_movil (
                id_tipo_movil INTEGER NOT NULL DEFAULT nextval('public.tipo_movil_id_tipo_movil_seq'),
                descripcion VARCHAR(50) NOT NULL,
                CONSTRAINT id_tipo_movil PRIMARY KEY (id_tipo_movil)
);


ALTER SEQUENCE public.tipo_movil_id_tipo_movil_seq OWNED BY public.tipo_movil.id_tipo_movil;

CREATE SEQUENCE public.moviles_id_movil_seq;

CREATE TABLE public.moviles (
                id_movil INTEGER NOT NULL DEFAULT nextval('public.moviles_id_movil_seq'),
                id_marca INTEGER NOT NULL,
                matricula VARCHAR(6) NOT NULL,
                ao INTEGER NOT NULL,
                id_tipo_movil INTEGER NOT NULL,
                CONSTRAINT moviles_pk PRIMARY KEY (id_movil)
);


ALTER SEQUENCE public.moviles_id_movil_seq OWNED BY public.moviles.id_movil;

CREATE SEQUENCE public.itinerario_id_itinerario_seq;

CREATE TABLE public.itinerario (
                id_itinerario INTEGER NOT NULL DEFAULT nextval('public.itinerario_id_itinerario_seq'),
                id_ruta INTEGER NOT NULL,
                hora_inicio TIMESTAMP NOT NULL,
                hora_fin TIMESTAMP NOT NULL,
                id_movil INTEGER NOT NULL,
                CONSTRAINT id_itinerario PRIMARY KEY (id_itinerario)
);


ALTER SEQUENCE public.itinerario_id_itinerario_seq OWNED BY public.itinerario.id_itinerario;

CREATE SEQUENCE public.equipo_id_equipo_seq;

CREATE TABLE public.equipo (
                id_equipo INTEGER NOT NULL DEFAULT nextval('public.equipo_id_equipo_seq'),
                descripcion VARCHAR(100) NOT NULL,
                CONSTRAINT id_equipo PRIMARY KEY (id_equipo)
);


ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipo.id_equipo;

CREATE SEQUENCE public.tipo_reclamo_id_tipo_reclamo_seq;

CREATE TABLE public.tipo_reclamo (
                id_tipo_reclamo INTEGER NOT NULL DEFAULT nextval('public.tipo_reclamo_id_tipo_reclamo_seq'),
                descripcion VARCHAR(50) NOT NULL,
                CONSTRAINT pk_id_tipo_reclamo PRIMARY KEY (id_tipo_reclamo)
);


ALTER SEQUENCE public.tipo_reclamo_id_tipo_reclamo_seq OWNED BY public.tipo_reclamo.id_tipo_reclamo;

CREATE SEQUENCE public.departamento_id_departamento_seq;

CREATE TABLE public.departamento (
                id_departamento INTEGER NOT NULL DEFAULT nextval('public.departamento_id_departamento_seq'),
                descripcion VARCHAR(50) NOT NULL,
                CONSTRAINT id_departamento PRIMARY KEY (id_departamento)
);


ALTER SEQUENCE public.departamento_id_departamento_seq OWNED BY public.departamento.id_departamento;

CREATE SEQUENCE public.usuario_id_usuario_seq;

CREATE TABLE public.usuario (
                id_usuario INTEGER NOT NULL DEFAULT nextval('public.usuario_id_usuario_seq'),
                nombre VARCHAR(30) NOT NULL,
                contrasenha VARCHAR(20) NOT NULL,
                rol VARCHAR(5),
                id_departamento INTEGER NOT NULL,
                estado VARCHAR(10) NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);


ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;

CREATE SEQUENCE public.estado_id_estado_seq;

CREATE TABLE public.estado (
                id_estado INTEGER NOT NULL DEFAULT nextval('public.estado_id_estado_seq'),
                descripcion VARCHAR(20) NOT NULL,
                CONSTRAINT id_estado PRIMARY KEY (id_estado)
);


ALTER SEQUENCE public.estado_id_estado_seq OWNED BY public.estado.id_estado;

CREATE SEQUENCE public.ciudad_id_ciudad_seq;

CREATE TABLE public.ciudad (
                id_ciudad INTEGER NOT NULL DEFAULT nextval('public.ciudad_id_ciudad_seq'),
                ciudad VARCHAR(60) NOT NULL,
                CONSTRAINT ciudad_pk PRIMARY KEY (id_ciudad)
);


ALTER SEQUENCE public.ciudad_id_ciudad_seq OWNED BY public.ciudad.id_ciudad;

CREATE TABLE public.empresa (
                id_empresa INTEGER NOT NULL,
                propietario VARCHAR(30) NOT NULL,
                nombre VARCHAR(50) NOT NULL,
                direccion VARCHAR(50) NOT NULL,
                telefono VARCHAR(15) NOT NULL,
                ruc VARCHAR(15) NOT NULL,
                rubro VARCHAR(50) NOT NULL,
                id_ciudad INTEGER NOT NULL,
                CONSTRAINT empresa_pk PRIMARY KEY (id_empresa)
);


CREATE SEQUENCE public.zona_id_zona_seq;

CREATE TABLE public.zona (
                id_zona INTEGER NOT NULL DEFAULT nextval('public.zona_id_zona_seq'),
                descripcion VARCHAR(50) NOT NULL,
                id_ciudad INTEGER NOT NULL,
                CONSTRAINT id_zona PRIMARY KEY (id_zona)
);


ALTER SEQUENCE public.zona_id_zona_seq OWNED BY public.zona.id_zona;

CREATE SEQUENCE public.cuadrilla_id_cuadrilla_seq;

CREATE TABLE public.cuadrilla (
                id_cuadrilla INTEGER NOT NULL DEFAULT nextval('public.cuadrilla_id_cuadrilla_seq'),
                id_tipo_cuadrilla INTEGER NOT NULL,
                id_movil INTEGER NOT NULL,
                id_zona INTEGER NOT NULL,
                id_tecnico INTEGER NOT NULL,
                CONSTRAINT id_cuadrilla PRIMARY KEY (id_cuadrilla)
);


ALTER SEQUENCE public.cuadrilla_id_cuadrilla_seq OWNED BY public.cuadrilla.id_cuadrilla;

CREATE SEQUENCE public.sucursal_id_sucursal_seq;

CREATE TABLE public.sucursal (
                id_sucursal INTEGER NOT NULL DEFAULT nextval('public.sucursal_id_sucursal_seq'),
                descripcion VARCHAR(50) NOT NULL,
                dir_sucursal VARCHAR(50) NOT NULL,
                tel_sucursal VARCHAR(30) NOT NULL,
                id_ciudad INTEGER NOT NULL,
                CONSTRAINT id_sucursal PRIMARY KEY (id_sucursal)
);


ALTER SEQUENCE public.sucursal_id_sucursal_seq OWNED BY public.sucursal.id_sucursal;

CREATE SEQUENCE public.serie_comprobante_id_serie_comprobante_seq_1;

CREATE TABLE public.serie_comprobante (
                id_serie_comprobante INTEGER NOT NULL DEFAULT nextval('public.serie_comprobante_id_serie_comprobante_seq_1'),
                id_sucursal INTEGER NOT NULL,
                descripcion VARCHAR(20) NOT NULL,
                prefijo VARCHAR(5) NOT NULL,
                CONSTRAINT serie_comprobante_pk PRIMARY KEY (id_serie_comprobante)
);


ALTER SEQUENCE public.serie_comprobante_id_serie_comprobante_seq_1 OWNED BY public.serie_comprobante.id_serie_comprobante;

CREATE SEQUENCE public.apertura_cierre_caja_id_apertura_cierre_seq;

CREATE TABLE public.apertura_cierre_caja (
                id_apertura_cierre INTEGER NOT NULL DEFAULT nextval('public.apertura_cierre_caja_id_apertura_cierre_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_caja INTEGER NOT NULL,
                fecha_apertura DATE NOT NULL,
                hora_apertura TIME NOT NULL,
                fecha_cierre DATE NOT NULL,
                hora_cierre TIME NOT NULL,
                monto_apertura INTEGER NOT NULL,
                CONSTRAINT apertura_cierre_caja_pk PRIMARY KEY (id_apertura_cierre)
);


ALTER SEQUENCE public.apertura_cierre_caja_id_apertura_cierre_seq OWNED BY public.apertura_cierre_caja.id_apertura_cierre;

CREATE TABLE public.cobro (
                id_cobro INTEGER NOT NULL,
                id_apertura_cierre INTEGER NOT NULL,
                id_forma_cobro INTEGER NOT NULL,
                fecha_cobro DATE NOT NULL,
                nro_recibo VARCHAR(50) NOT NULL,
                efectivo INTEGER NOT NULL,
                estado_cobro VARCHAR(50) NOT NULL,
                CONSTRAINT cobro_pk PRIMARY KEY (id_cobro)
);


CREATE SEQUENCE public.arqueo_id_arqueo_seq;

CREATE TABLE public.arqueo (
                id_arqueo INTEGER NOT NULL DEFAULT nextval('public.arqueo_id_arqueo_seq'),
                id_valor INTEGER NOT NULL,
                id_apertura_cierre INTEGER NOT NULL,
                cantidad_valor INTEGER NOT NULL,
                fecha_arqueo DATE NOT NULL,
                hora_arqueo TIME NOT NULL,
                estado_arqueo VARCHAR(40) NOT NULL,
                CONSTRAINT arqueo_pk PRIMARY KEY (id_arqueo, id_valor, id_apertura_cierre)
);


ALTER SEQUENCE public.arqueo_id_arqueo_seq OWNED BY public.arqueo.id_arqueo;

CREATE SEQUENCE public.recaudacion_id_recaudacion_seq;

CREATE TABLE public.recaudacion (
                id_recaudacion INTEGER NOT NULL DEFAULT nextval('public.recaudacion_id_recaudacion_seq'),
                id_forma_cobro INTEGER NOT NULL,
                id_arqueo INTEGER NOT NULL,
                id_valor INTEGER NOT NULL,
                id_apertura_cierre INTEGER NOT NULL,
                fecha_recaudacion DATE NOT NULL,
                monto_recaudacion INTEGER NOT NULL,
                CONSTRAINT recaudacion_pk PRIMARY KEY (id_recaudacion, id_forma_cobro)
);


ALTER SEQUENCE public.recaudacion_id_recaudacion_seq OWNED BY public.recaudacion.id_recaudacion;

CREATE SEQUENCE public.promocion_id_promocion_seq;

CREATE TABLE public.promocion (
                id_promocion INTEGER NOT NULL DEFAULT nextval('public.promocion_id_promocion_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                descipcion VARCHAR(100) NOT NULL,
                fecha_ini_promo DATE NOT NULL,
                fecha_fin_promo DATE NOT NULL,
                CONSTRAINT id_promocion PRIMARY KEY (id_promocion)
);


ALTER SEQUENCE public.promocion_id_promocion_seq OWNED BY public.promocion.id_promocion;

CREATE SEQUENCE public.servicio_id_servicio_seq;

CREATE TABLE public.servicio (
                id_servicio INTEGER NOT NULL DEFAULT nextval('public.servicio_id_servicio_seq'),
                descripcion VARCHAR(30) NOT NULL,
                cantidad INTEGER NOT NULL,
                id_estado INTEGER NOT NULL,
                costo INTEGER NOT NULL,
                id_moneda INTEGER NOT NULL,
                id_descuento INTEGER NOT NULL,
                id_promocion INTEGER NOT NULL,
                CONSTRAINT id_servicio PRIMARY KEY (id_servicio)
);


ALTER SEQUENCE public.servicio_id_servicio_seq OWNED BY public.servicio.id_servicio;

CREATE TABLE public.promocion_1 (
                id_promocion INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_equipo INTEGER NOT NULL,
                id_servicio INTEGER NOT NULL,
                costo_promo INTEGER NOT NULL,
                CONSTRAINT id_promocion PRIMARY KEY (id_promocion, id_secuencia)
);


CREATE TABLE public.nacionalidad (
                id_nacionalidad INTEGER NOT NULL,
                descripcion VARCHAR(30) NOT NULL,
                CONSTRAINT id_nacionalidad PRIMARY KEY (id_nacionalidad)
);


CREATE SEQUENCE public.tipo_documento_id_tipo_documento_seq;

CREATE TABLE public.tipo_documento (
                id_tipo_documento INTEGER NOT NULL DEFAULT nextval('public.tipo_documento_id_tipo_documento_seq'),
                descripcion VARCHAR(100) NOT NULL,
                CONSTRAINT tipo_documento_pk PRIMARY KEY (id_tipo_documento)
);


ALTER SEQUENCE public.tipo_documento_id_tipo_documento_seq OWNED BY public.tipo_documento.id_tipo_documento;

CREATE TABLE public.cliente (
                id_cliente INTEGER NOT NULL,
                nombre VARCHAR(100) NOT NULL,
                apellido VARCHAR(100) NOT NULL,
                id_tipo_documento INTEGER NOT NULL,
                id_nacionalidad INTEGER NOT NULL,
                numero_documento VARCHAR(30) NOT NULL,
                direccion VARCHAR(100) NOT NULL,
                telefono INTEGER NOT NULL,
                id_ciudad INTEGER NOT NULL,
                e_mail VARCHAR(60) NOT NULL,
                estado_cliente VARCHAR(10) NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);


CREATE INDEX fki_cliente_ciudad
 ON public.cliente USING BTREE
 ( nombre );

CREATE INDEX fki_cliente_estado
 ON public.cliente USING BTREE
 ( apellido );

CREATE UNIQUE INDEX cliente_idx
 ON public.cliente
 ( numero_documento );

CREATE TABLE public.segmento_contrato (
                id_segmento INTEGER NOT NULL,
                descripcion VARCHAR(60) NOT NULL,
                id_servicio INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                CONSTRAINT id_segmento PRIMARY KEY (id_segmento)
);


CREATE SEQUENCE public.solicitud_id_solicitud_seq;

CREATE TABLE public.solicitud (
                id_solicitud INTEGER NOT NULL DEFAULT nextval('public.solicitud_id_solicitud_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                fecha_solicitud DATE NOT NULL,
                estado VARCHAR(50) NOT NULL,
                CONSTRAINT id_solicitud PRIMARY KEY (id_solicitud)
);


ALTER SEQUENCE public.solicitud_id_solicitud_seq OWNED BY public.solicitud.id_solicitud;

CREATE TABLE public.solicitud_det (
                id_solicitud INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                descripcion VARCHAR(250) NOT NULL,
                id_servicio INTEGER NOT NULL,
                id_promocion INTEGER NOT NULL,
                id_descuento INTEGER NOT NULL,
                CONSTRAINT id_solicitud PRIMARY KEY (id_solicitud, id_secuencia)
);


CREATE SEQUENCE public.contrato_id_contrato_seq;

CREATE TABLE public.contrato (
                id_contrato INTEGER NOT NULL DEFAULT nextval('public.contrato_id_contrato_seq'),
                id_cliente INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                fecha_ingreso DATE NOT NULL,
                id_estado INTEGER NOT NULL,
                id_servicio INTEGER NOT NULL,
                CONSTRAINT id_contrato PRIMARY KEY (id_contrato, id_cliente)
);


ALTER SEQUENCE public.contrato_id_contrato_seq OWNED BY public.contrato.id_contrato;

CREATE SEQUENCE public.cuenta_cliente_id_cuenta_cliente_seq;

CREATE TABLE public.cuenta_cliente (
                id_cuenta INTEGER NOT NULL DEFAULT nextval('public.cuenta_cliente_id_cuenta_cliente_seq'),
                id_cliente INTEGER NOT NULL,
                id_contrato INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                contacto VARCHAR(50) NOT NULL,
                fecha_habilitacion DATE NOT NULL,
                id_estado INTEGER NOT NULL,
                id_segmento INTEGER NOT NULL,
                CONSTRAINT id_cuenta PRIMARY KEY (id_cuenta)
);


ALTER SEQUENCE public.cuenta_cliente_id_cuenta_cliente_seq OWNED BY public.cuenta_cliente.id_cuenta;

CREATE SEQUENCE public.reclamo_id_reclamo_seq;

CREATE TABLE public.reclamo (
                id_reclamo INTEGER NOT NULL DEFAULT nextval('public.reclamo_id_reclamo_seq'),
                id_cliente INTEGER NOT NULL,
                id_estado INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_departamento INTEGER NOT NULL,
                id_tipo_reclamo INTEGER NOT NULL,
                descripcion VARCHAR(5000) NOT NULL,
                fecha_alta DATE NOT NULL,
                id_tipo_reclamo_1 DATE,
                solucion VARCHAR(150),
                contacto VARCHAR(50) NOT NULL,
                id_sucursal INTEGER NOT NULL,
                CONSTRAINT reclamo_pk PRIMARY KEY (id_reclamo)
);


ALTER SEQUENCE public.reclamo_id_reclamo_seq OWNED BY public.reclamo.id_reclamo;

CREATE INDEX fki_estado_trab_fk
 ON public.reclamo USING BTREE
 ( id_estado );

CREATE INDEX fki_reclamo_sucursal
 ON public.reclamo USING BTREE
 ( contacto );

CREATE SEQUENCE public.diagnostico_id_diagnostico_seq;

CREATE TABLE public.diagnostico (
                id_diagnostico INTEGER NOT NULL DEFAULT nextval('public.diagnostico_id_diagnostico_seq'),
                id_reclamo INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                fecha_diagnostico DATE NOT NULL,
                estado_diag VARCHAR(50) NOT NULL,
                CONSTRAINT id_diagnostico PRIMARY KEY (id_diagnostico)
);


ALTER SEQUENCE public.diagnostico_id_diagnostico_seq OWNED BY public.diagnostico.id_diagnostico;

CREATE SEQUENCE public.presupuesto_id_presupuesto_seq;

CREATE TABLE public.presupuesto (
                id_presupuesto INTEGER NOT NULL DEFAULT nextval('public.presupuesto_id_presupuesto_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                fecha DATE NOT NULL,
                id_estado INTEGER NOT NULL,
                plazo VARCHAR(30) NOT NULL,
                validez VARCHAR(30) NOT NULL,
                exenta INTEGER NOT NULL,
                gravada5 INTEGER NOT NULL,
                gravada10 INTEGER NOT NULL,
                iva5 INTEGER NOT NULL,
                iva10 INTEGER NOT NULL,
                id_diagnostico INTEGER NOT NULL,
                CONSTRAINT id_presupuesto PRIMARY KEY (id_presupuesto)
);


ALTER SEQUENCE public.presupuesto_id_presupuesto_seq OWNED BY public.presupuesto.id_presupuesto;

CREATE TABLE public.venta (
                id_venta INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                id_tipo_comprobante INTEGER NOT NULL,
                id_serie_comprobante INTEGER NOT NULL,
                nro_comprobante INTEGER NOT NULL,
                id_timbrado INTEGER NOT NULL,
                id_apertura_cierre INTEGER NOT NULL,
                id_presupuesto INTEGER NOT NULL,
                cantidad_cuota INTEGER NOT NULL,
                fecha_venta DATE NOT NULL,
                estado_venta VARCHAR NOT NULL,
                exenta INTEGER NOT NULL,
                gravada5 INTEGER NOT NULL,
                gravada10 INTEGER NOT NULL,
                iva5 INTEGER NOT NULL,
                iva10 INTEGER NOT NULL,
                CONSTRAINT venta_pk PRIMARY KEY (id_venta)
);


CREATE SEQUENCE public.nota_remision_venta_id_remision_seq;

CREATE TABLE public.nota_remision_venta (
                id_remision INTEGER NOT NULL DEFAULT nextval('public.nota_remision_venta_id_remision_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_motivo_nota INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                id_movil INTEGER NOT NULL,
                fecha_salida DATE NOT NULL,
                fecha_llegada DATE NOT NULL,
                punto_salida VARCHAR(60) NOT NULL,
                punto_llegada VARCHAR(60) NOT NULL,
                estado_remision VARCHAR(50) NOT NULL,
                id_tipo_comprobante INTEGER NOT NULL,
                CONSTRAINT nota_remision_venta_pk PRIMARY KEY (id_remision)
);


ALTER SEQUENCE public.nota_remision_venta_id_remision_seq OWNED BY public.nota_remision_venta.id_remision;

CREATE TABLE public.nota_remision_venta_det (
                id_remision INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_equipo INTEGER NOT NULL,
                cantidad_remision INTEGER NOT NULL,
                CONSTRAINT nota_remision_venta_det_pk PRIMARY KEY (id_remision, id_secuencia)
);


CREATE SEQUENCE public.libro_venta_id_libro_venta_seq;

CREATE TABLE public.libro_venta (
                id_libro_venta INTEGER NOT NULL DEFAULT nextval('public.libro_venta_id_libro_venta_seq'),
                id_venta INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                ruc_cliente VARCHAR(20) NOT NULL,
                venta_exenta INTEGER NOT NULL,
                venta_gravada10 INTEGER NOT NULL,
                venta_gravada5 INTEGER NOT NULL,
                iva_gravada10 INTEGER NOT NULL,
                iva_gravada5 INTEGER NOT NULL,
                estado_libro_venta VARCHAR(50) NOT NULL,
                periodo_venta VARCHAR(60) NOT NULL,
                CONSTRAINT libro_venta_pk PRIMARY KEY (id_libro_venta, id_venta)
);


ALTER SEQUENCE public.libro_venta_id_libro_venta_seq OWNED BY public.libro_venta.id_libro_venta;

CREATE SEQUENCE public.nota_credi_debi_venta_id_nota_venta_seq;

CREATE TABLE public.nota_credi_debi_venta (
                id_nota_venta INTEGER NOT NULL DEFAULT nextval('public.nota_credi_debi_venta_id_nota_venta_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                id_motivo_nota INTEGER NOT NULL,
                id_tipo_comprobante INTEGER NOT NULL,
                id_serie_comprobante INTEGER NOT NULL,
                nro_comprobante INTEGER NOT NULL,
                id_timbrado INTEGER NOT NULL,
                fecha_nota_venta DATE NOT NULL,
                estado_nota_venta VARCHAR(50) NOT NULL,
                exenta_nota INTEGER NOT NULL,
                gravada10_nota INTEGER NOT NULL,
                gravada5_nota INTEGER NOT NULL,
                iva10_nota INTEGER NOT NULL,
                iva5_nota INTEGER NOT NULL,
                CONSTRAINT nota_credi_debi_venta_pk PRIMARY KEY (id_nota_venta)
);


ALTER SEQUENCE public.nota_credi_debi_venta_id_nota_venta_seq OWNED BY public.nota_credi_debi_venta.id_nota_venta;

CREATE TABLE public.nota_credi_debi_venta_det (
                id_nota_venta INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_equipo INTEGER NOT NULL,
                precio_nota_venta INTEGER NOT NULL,
                cantidad_nota_venta INTEGER NOT NULL,
                exenta_nota_venta INTEGER NOT NULL,
                gravada10_nota_venta INTEGER NOT NULL,
                gravada5_nota_venta INTEGER NOT NULL,
                iva10_nota_venta INTEGER NOT NULL,
                iva5_nota_venta INTEGER NOT NULL,
                CONSTRAINT nota_credi_debi_venta_det_pk PRIMARY KEY (id_nota_venta, id_secuencia)
);


CREATE TABLE public.cta_a_cobrar (
                id_cta_a_cobrar INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                nro_cuota INTEGER NOT NULL,
                monto_a_cobrar INTEGER NOT NULL,
                saldo_a_cobrar INTEGER NOT NULL,
                vencimiento_a_cobrar DATE NOT NULL,
                estado_a_cobrar VARCHAR(50) NOT NULL,
                CONSTRAINT cta_a_cobrar_pk PRIMARY KEY (id_cta_a_cobrar, id_venta)
);


CREATE TABLE public.cobro_det (
                id_cobro INTEGER NOT NULL,
                id_cta_a_cobrar INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                monto_cobro_det INTEGER NOT NULL,
                CONSTRAINT cobro_det_pk PRIMARY KEY (id_cobro, id_cta_a_cobrar, id_venta)
);


CREATE SEQUENCE public.cobro_tarjeta_id_cobro_tarjeta_seq;

CREATE TABLE public.cobro_tarjeta (
                id_cobro_tarjeta INTEGER NOT NULL DEFAULT nextval('public.cobro_tarjeta_id_cobro_tarjeta_seq'),
                id_cobro INTEGER NOT NULL,
                id_cta_a_cobrar INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                id_tarjeta INTEGER NOT NULL,
                monto_cobro_tarjeta INTEGER NOT NULL,
                cuota_tarjeta INTEGER NOT NULL,
                cod_autorizacion INTEGER NOT NULL,
                vaucher_nro INTEGER NOT NULL,
                CONSTRAINT cobro_tarjeta_pk PRIMARY KEY (id_cobro_tarjeta, id_cobro, id_cta_a_cobrar, id_venta)
);


ALTER SEQUENCE public.cobro_tarjeta_id_cobro_tarjeta_seq OWNED BY public.cobro_tarjeta.id_cobro_tarjeta;

CREATE SEQUENCE public.cobro_cheque_id_cobro_cheque_seq;

CREATE TABLE public.cobro_cheque (
                id_cobro_cheque INTEGER NOT NULL DEFAULT nextval('public.cobro_cheque_id_cobro_cheque_seq'),
                id_cobro INTEGER NOT NULL,
                id_cta_a_cobrar INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                fecha_emision DATE NOT NULL,
                fecha_vencimiento DATE NOT NULL,
                titular_cheque VARCHAR(100) NOT NULL,
                id_banco INTEGER NOT NULL,
                nro_cheque VARCHAR(60) NOT NULL,
                monto_cheque INTEGER NOT NULL,
                CONSTRAINT cobro_cheque_pk PRIMARY KEY (id_cobro_cheque, id_cobro, id_cta_a_cobrar, id_venta)
);


ALTER SEQUENCE public.cobro_cheque_id_cobro_cheque_seq OWNED BY public.cobro_cheque.id_cobro_cheque;

CREATE TABLE public.venta_det (
                id_venta INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_promocion INTEGER NOT NULL,
                id_descuento INTEGER NOT NULL,
                id_equipo INTEGER NOT NULL,
                cantidad INTEGER NOT NULL,
                precio_venta INTEGER NOT NULL,
                exento INTEGER NOT NULL,
                gravada5 INTEGER NOT NULL,
                gravada10 INTEGER NOT NULL,
                iva5 INTEGER NOT NULL,
                iva10 INTEGER NOT NULL,
                CONSTRAINT venta_det_pk PRIMARY KEY (id_venta, id_secuencia)
);


CREATE TABLE public.presupuesto_det (
                id_presupuesto INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_promocion INTEGER NOT NULL,
                id_descuento INTEGER NOT NULL,
                cantidad INTEGER NOT NULL,
                exenta INTEGER NOT NULL,
                gravada5 INTEGER NOT NULL,
                gravada10 INTEGER NOT NULL,
                precio INTEGER NOT NULL,
                CONSTRAINT id_presupuesto PRIMARY KEY (id_presupuesto, id_secuencia)
);


CREATE TABLE public.diagnostico_det (
                id_diagnostico INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                id_equipo INTEGER NOT NULL,
                detalle VARCHAR(300) NOT NULL,
                CONSTRAINT id_diagnostico PRIMARY KEY (id_diagnostico, id_secuencia)
);


CREATE SEQUENCE public.orden_trabajo_id_orden_trabajo_seq;

CREATE TABLE public.orden_trabajo (
                id_orden_trabajo INTEGER NOT NULL DEFAULT nextval('public.orden_trabajo_id_orden_trabajo_seq'),
                id_usuario INTEGER NOT NULL,
                id_sucursal INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                id_presupuesto INTEGER NOT NULL,
                id_reclamo INTEGER NOT NULL,
                id_solicitud INTEGER NOT NULL,
                id_cuadrilla INTEGER NOT NULL,
                id_itinerario INTEGER NOT NULL,
                fecha_orden DATE NOT NULL,
                id_estado INTEGER NOT NULL,
                CONSTRAINT id_orden_trabajo PRIMARY KEY (id_orden_trabajo)
);


ALTER SEQUENCE public.orden_trabajo_id_orden_trabajo_seq OWNED BY public.orden_trabajo.id_orden_trabajo;

CREATE SEQUENCE public.instalacion_cab_id_instalacion_seq;

CREATE TABLE public.instalacion_cab (
                id_instalacion INTEGER NOT NULL DEFAULT nextval('public.instalacion_cab_id_instalacion_seq'),
                id_orden_trabajo INTEGER NOT NULL,
                tipo_instalacion VARCHAR(20) NOT NULL,
                fecha_inicio DATE NOT NULL,
                fecha_fin DATE NOT NULL,
                id_estado INTEGER NOT NULL,
                observacion VARCHAR(100) NOT NULL,
                CONSTRAINT instalacion_cab_pk PRIMARY KEY (id_instalacion)
);


ALTER SEQUENCE public.instalacion_cab_id_instalacion_seq OWNED BY public.instalacion_cab.id_instalacion;

CREATE TABLE public.instalacion_det (
                id_instalacion INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                detalle VARCHAR(200) NOT NULL,
                id_equipo INTEGER NOT NULL,
                CONSTRAINT instalacion_det_pk PRIMARY KEY (id_instalacion, id_secuencia)
);


CREATE TABLE public.orden_trabajo_det (
                id_orden_trabajo INTEGER NOT NULL,
                id_secuencia INTEGER NOT NULL,
                detalle VARCHAR(400) NOT NULL,
                CONSTRAINT id_orden_trabajo PRIMARY KEY (id_orden_trabajo, id_secuencia)
);


ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT motivo_nota_debi_nota_credi_debi_venta_fk
FOREIGN KEY (id_motivo_nota)
REFERENCES public.motivo_nota_debi (id_motivo_nota)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT motivo_nota_debi_nota_remision_venta_fk
FOREIGN KEY (id_motivo_nota)
REFERENCES public.motivo_nota_debi (id_motivo_nota)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tarjeta ADD CONSTRAINT entidad_emisora_tarjeta_fk
FOREIGN KEY (id_entidad_emisora)
REFERENCES public.entidad_emisora (id_entidad_emisora)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tarjeta ADD CONSTRAINT tipo_tarjeta_tarjeta_fk
FOREIGN KEY (id_tipo_tarjeta)
REFERENCES public.tipo_tarjeta (id_tipo_tarjeta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tarjeta ADD CONSTRAINT marca_tarjeta_tarjeta_fk
FOREIGN KEY (id_marca_tarjeta)
REFERENCES public.marca_tarjeta (id_marca_tarjeta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_tarjeta ADD CONSTRAINT tarjeta_cobro_tarjeta_fk
FOREIGN KEY (id_tarjeta)
REFERENCES public.tarjeta (id_tarjeta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_cheque ADD CONSTRAINT banco_cobro_cheque_fk
FOREIGN KEY (id_banco)
REFERENCES public.banco (id_banco)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.recaudacion ADD CONSTRAINT forma_cobro_recaudacion_fk
FOREIGN KEY (id_forma_cobro)
REFERENCES public.forma_cobro (id_forma_cobro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro ADD CONSTRAINT forma_cobro_cobro_fk
FOREIGN KEY (id_forma_cobro)
REFERENCES public.forma_cobro (id_forma_cobro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.arqueo ADD CONSTRAINT valor_arqueo_fk
FOREIGN KEY (id_valor)
REFERENCES public.valor (id_valor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT tipo_comprobante_venta_fk
FOREIGN KEY (id_tipo_comprobante)
REFERENCES public.tipo_comprobante (id_tipo_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.timbrado ADD CONSTRAINT tipo_comprobante_timbrado_fk
FOREIGN KEY (id_tipo_comprobante)
REFERENCES public.tipo_comprobante (id_tipo_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT tipo_comprobante_nota_credi_debi_venta_fk
FOREIGN KEY (id_tipo_comprobante)
REFERENCES public.tipo_comprobante (id_tipo_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT tipo_comprobante_nota_remision_venta_fk
FOREIGN KEY (id_tipo_comprobante)
REFERENCES public.tipo_comprobante (id_tipo_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT timbrado_venta_fk
FOREIGN KEY (id_timbrado)
REFERENCES public.timbrado (id_timbrado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT timbrado_nota_credi_debi_venta_fk
FOREIGN KEY (id_timbrado)
REFERENCES public.timbrado (id_timbrado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.apertura_cierre_caja ADD CONSTRAINT caja_apertura_cierre_caja_fk
FOREIGN KEY (id_caja)
REFERENCES public.caja (id_caja)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio ADD CONSTRAINT moneda_servicio_fk
FOREIGN KEY (id_moneda)
REFERENCES public.moneda (id_moneda)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.descuento_det ADD CONSTRAINT descuento_descuento_det_fk
FOREIGN KEY (id_descuento)
REFERENCES public.descuento (id_descuento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto_det ADD CONSTRAINT descuento_presupuesto_det_fk
FOREIGN KEY (id_descuento)
REFERENCES public.descuento (id_descuento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio ADD CONSTRAINT descuento_servicio_fk
FOREIGN KEY (id_descuento)
REFERENCES public.descuento (id_descuento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud_det ADD CONSTRAINT descuento_solicitud_det_fk
FOREIGN KEY (id_descuento)
REFERENCES public.descuento (id_descuento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_det ADD CONSTRAINT descuento_venta_det_fk
FOREIGN KEY (id_descuento)
REFERENCES public.descuento (id_descuento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuadrilla ADD CONSTRAINT tecnico_cuadrilla_fk
FOREIGN KEY (id_tecnico)
REFERENCES public.tecnico (id_tecnico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.itinerario ADD CONSTRAINT ruta_itinerario_fk
FOREIGN KEY (id_ruta)
REFERENCES public.ruta (id_ruta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuadrilla ADD CONSTRAINT tipo_cuadrilla_cuadrilla_fk
FOREIGN KEY (id_tipo_cuadrilla)
REFERENCES public.tipo_cuadrilla (id_tipo_cuadrilla)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.moviles ADD CONSTRAINT marca_moviles_fk
FOREIGN KEY (id_marca)
REFERENCES public.marca (id_marca)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.moviles ADD CONSTRAINT tipo_movil_moviles_fk
FOREIGN KEY (id_tipo_movil)
REFERENCES public.tipo_movil (id_tipo_movil)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.itinerario ADD CONSTRAINT moviles_itinerario_fk
FOREIGN KEY (id_movil)
REFERENCES public.moviles (id_movil)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuadrilla ADD CONSTRAINT moviles_cuadrilla_fk
FOREIGN KEY (id_movil)
REFERENCES public.moviles (id_movil)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT moviles_remision_venta_fk
FOREIGN KEY (id_movil)
REFERENCES public.moviles (id_movil)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT itinerario_orden_trabajo_fk
FOREIGN KEY (id_itinerario)
REFERENCES public.itinerario (id_itinerario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.diagnostico_det ADD CONSTRAINT equipo_diagnostico_det_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.promocion_1 ADD CONSTRAINT equipo_promocion_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.instalacion_det ADD CONSTRAINT equipo_instalacion_det_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_det ADD CONSTRAINT equipo_venta_det_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta_det ADD CONSTRAINT equipo_nota_credi_debi_venta_det_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta_det ADD CONSTRAINT equipo_remision_venta_det_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT tipo_reclamo_reclamo_fk
FOREIGN KEY (id_tipo_reclamo)
REFERENCES public.tipo_reclamo (id_tipo_reclamo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT departamento_reclamo_fk
FOREIGN KEY (id_departamento)
REFERENCES public.departamento (id_departamento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT usuario_reclamo_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT usuario_orden_trabajo_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.diagnostico ADD CONSTRAINT usuario_diagnostico_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto ADD CONSTRAINT usuario_presupuesto_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.promocion ADD CONSTRAINT usuario_promocion_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud ADD CONSTRAINT usuario_solicitud_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.apertura_cierre_caja ADD CONSTRAINT usuario_apertura_cierre_caja_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT usuario_venta_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT usuario_nota_credi_debi_venta_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT usuario_remision_venta_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT estado_reclamo_fk
FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto ADD CONSTRAINT estado_presupuesto_fk
FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio ADD CONSTRAINT estado_servicio_fk
FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT estado_contrato_fk
FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cliente ADD CONSTRAINT estado_cuenta_cliente_fk
FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cliente ADD CONSTRAINT ciudad_cliente_fk
FOREIGN KEY (id_ciudad)
REFERENCES public.ciudad (id_ciudad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sucursal ADD CONSTRAINT ciudad_sucursal_fk
FOREIGN KEY (id_ciudad)
REFERENCES public.ciudad (id_ciudad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.zona ADD CONSTRAINT ciudad_zona_fk
FOREIGN KEY (id_ciudad)
REFERENCES public.ciudad (id_ciudad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.empresa ADD CONSTRAINT ciudad_empresa_fk
FOREIGN KEY (id_ciudad)
REFERENCES public.ciudad (id_ciudad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuadrilla ADD CONSTRAINT zona_cuadrilla_fk
FOREIGN KEY (id_zona)
REFERENCES public.zona (id_zona)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT cuadrilla_orden_trabajo_fk
FOREIGN KEY (id_cuadrilla)
REFERENCES public.cuadrilla (id_cuadrilla)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.diagnostico ADD CONSTRAINT sucursal_diagnostico_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT sucursal_reclamo_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT sucursal_orden_trabajo_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto ADD CONSTRAINT sucursal_presupuesto_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.promocion ADD CONSTRAINT sucursal_promocion_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT sucursal_contrato_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud ADD CONSTRAINT sucursal_solicitud_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cliente ADD CONSTRAINT sucursal_cuenta_cliente_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.apertura_cierre_caja ADD CONSTRAINT sucursal_apertura_cierre_caja_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT sucursal_venta_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT sucursal_nota_credi_debi_venta_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT sucursal_remision_venta_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.serie_comprobante ADD CONSTRAINT sucursal_serie_comprobante_fk
FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT serie_comprobante_venta_fk
FOREIGN KEY (id_serie_comprobante)
REFERENCES public.serie_comprobante (id_serie_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT serie_comprobante_nota_credi_debi_venta_fk
FOREIGN KEY (id_serie_comprobante)
REFERENCES public.serie_comprobante (id_serie_comprobante)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.arqueo ADD CONSTRAINT apertura_cierre_caja_arqueo_fk
FOREIGN KEY (id_apertura_cierre)
REFERENCES public.apertura_cierre_caja (id_apertura_cierre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT apertura_cierre_caja_venta_fk
FOREIGN KEY (id_apertura_cierre)
REFERENCES public.apertura_cierre_caja (id_apertura_cierre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro ADD CONSTRAINT apertura_cierre_caja_cobro_fk
FOREIGN KEY (id_apertura_cierre)
REFERENCES public.apertura_cierre_caja (id_apertura_cierre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_det ADD CONSTRAINT cobro_cobro_det_fk
FOREIGN KEY (id_cobro)
REFERENCES public.cobro (id_cobro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.recaudacion ADD CONSTRAINT arqueo_recaudacion_fk
FOREIGN KEY (id_arqueo, id_valor, id_apertura_cierre)
REFERENCES public.arqueo (id_arqueo, id_valor, id_apertura_cierre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.promocion_1 ADD CONSTRAINT promocion_promocion_fk
FOREIGN KEY (id_promocion)
REFERENCES public.promocion (id_promocion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto_det ADD CONSTRAINT promocion_presupuesto_det_fk
FOREIGN KEY (id_promocion)
REFERENCES public.promocion (id_promocion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio ADD CONSTRAINT promocion_servicio_fk
FOREIGN KEY (id_promocion)
REFERENCES public.promocion (id_promocion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud_det ADD CONSTRAINT promocion_solicitud_det_fk
FOREIGN KEY (id_promocion)
REFERENCES public.promocion (id_promocion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_det ADD CONSTRAINT promocion_venta_det_fk
FOREIGN KEY (id_promocion)
REFERENCES public.promocion (id_promocion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.promocion_1 ADD CONSTRAINT servicio_promocion_fk
FOREIGN KEY (id_servicio)
REFERENCES public.servicio (id_servicio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT servicio_contrato_fk
FOREIGN KEY (id_servicio)
REFERENCES public.servicio (id_servicio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud_det ADD CONSTRAINT servicio_solicitud_det_fk
FOREIGN KEY (id_servicio)
REFERENCES public.servicio (id_servicio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.segmento_contrato ADD CONSTRAINT servicio_segmento_contrato_fk
FOREIGN KEY (id_servicio)
REFERENCES public.servicio (id_servicio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cliente ADD CONSTRAINT nacionalidad_cliente_fk
FOREIGN KEY (id_nacionalidad)
REFERENCES public.nacionalidad (id_nacionalidad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cliente ADD CONSTRAINT tipo_documento_cliente_fk
FOREIGN KEY (id_tipo_documento)
REFERENCES public.tipo_documento (id_tipo_documento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reclamo ADD CONSTRAINT cliente_reclamo_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT cliente_orden_trabajo_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto ADD CONSTRAINT cliente_presupuesto_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT cliente_contrato_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud ADD CONSTRAINT cliente_solicitud_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.segmento_contrato ADD CONSTRAINT cliente_segmento_contrato_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cliente ADD CONSTRAINT cliente_cuenta_cliente_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT cliente_venta_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.libro_venta ADD CONSTRAINT cliente_libro_venta_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cliente ADD CONSTRAINT segmento_contrato_cuenta_cliente_fk
FOREIGN KEY (id_segmento)
REFERENCES public.segmento_contrato (id_segmento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.solicitud_det ADD CONSTRAINT solicitud_solicitud_det_fk
FOREIGN KEY (id_solicitud)
REFERENCES public.solicitud (id_solicitud)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT solicitud_orden_trabajo_fk
FOREIGN KEY (id_solicitud)
REFERENCES public.solicitud (id_solicitud)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cliente ADD CONSTRAINT contrato_cuenta_cliente_fk
FOREIGN KEY (id_contrato, id_cliente)
REFERENCES public.contrato (id_contrato, id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT reclamo_orden_trabajo_fk
FOREIGN KEY (id_reclamo)
REFERENCES public.reclamo (id_reclamo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.diagnostico ADD CONSTRAINT reclamo_diagnostico_fk
FOREIGN KEY (id_reclamo)
REFERENCES public.reclamo (id_reclamo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.diagnostico_det ADD CONSTRAINT diagnostico_diagnostico_det_fk
FOREIGN KEY (id_diagnostico)
REFERENCES public.diagnostico (id_diagnostico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto ADD CONSTRAINT diagnostico_presupuesto_fk
FOREIGN KEY (id_diagnostico)
REFERENCES public.diagnostico (id_diagnostico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.presupuesto_det ADD CONSTRAINT presupuesto_presupuesto_det_fk
FOREIGN KEY (id_presupuesto)
REFERENCES public.presupuesto (id_presupuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo ADD CONSTRAINT presupuesto_orden_trabajo_fk
FOREIGN KEY (id_presupuesto)
REFERENCES public.presupuesto (id_presupuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT presupuesto_venta_fk
FOREIGN KEY (id_presupuesto)
REFERENCES public.presupuesto (id_presupuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_det ADD CONSTRAINT venta_venta_det_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cta_a_cobrar ADD CONSTRAINT venta_cta_a_cobrar_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta ADD CONSTRAINT venta_nota_credi_debi_venta_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.libro_venta ADD CONSTRAINT venta_libro_venta_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta ADD CONSTRAINT venta_remision_venta_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_remision_venta_det ADD CONSTRAINT remision_venta_remision_venta_det_fk
FOREIGN KEY (id_remision)
REFERENCES public.nota_remision_venta (id_remision)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.nota_credi_debi_venta_det ADD CONSTRAINT nota_credi_debi_venta_nota_credi_debi_venta_det_fk
FOREIGN KEY (id_nota_venta)
REFERENCES public.nota_credi_debi_venta (id_nota_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_det ADD CONSTRAINT cta_a_cobrar_cobro_det_fk
FOREIGN KEY (id_cta_a_cobrar, id_venta)
REFERENCES public.cta_a_cobrar (id_cta_a_cobrar, id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_cheque ADD CONSTRAINT cobro_det_cobro_cheque_fk
FOREIGN KEY (id_cobro, id_cta_a_cobrar, id_venta)
REFERENCES public.cobro_det (id_cobro, id_cta_a_cobrar, id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_tarjeta ADD CONSTRAINT cobro_det_cobro_tarjeta_fk
FOREIGN KEY (id_cobro, id_cta_a_cobrar, id_venta)
REFERENCES public.cobro_det (id_cobro, id_cta_a_cobrar, id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_trabajo_det ADD CONSTRAINT orden_trabajo_orden_trabajo_det_fk
FOREIGN KEY (id_orden_trabajo)
REFERENCES public.orden_trabajo (id_orden_trabajo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.instalacion_cab ADD CONSTRAINT orden_trabajo_instalacion_cab_fk
FOREIGN KEY (id_orden_trabajo)
REFERENCES public.orden_trabajo (id_orden_trabajo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.instalacion_det ADD CONSTRAINT instalacion_cab_instalacion_det_fk
FOREIGN KEY (id_instalacion)
REFERENCES public.instalacion_cab (id_instalacion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;