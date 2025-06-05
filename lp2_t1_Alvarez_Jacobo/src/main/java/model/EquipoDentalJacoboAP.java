package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tbl_equipo_dental")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor

public class EquipoDentalJacoboAP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_equipo", nullable = false)
	@EqualsAndHashCode.Include
	private int nroEquipo;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "costo", nullable = false)
	private double costo;


	@Column(name = "fecha_adquisicion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fechaAdquisicion;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dentista")
	private DentistaJacoboAP dentista;

	
	@Override
	public String toString() {
	    return nombre; 
	}
	
    public EquipoDentalJacoboAP(String nombre, Double costo, String estado, DentistaJacoboAP dentista) {
        this.nombre = nombre;
        this.costo = costo;
		this.estado = estado;
		this.dentista = dentista;
		this.fechaAdquisicion = LocalDateTime.now();

    }

}
