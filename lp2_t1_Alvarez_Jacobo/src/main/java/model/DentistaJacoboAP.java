package model;

import java.util.Date;

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
@Table(name = "tbl_dentista")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor


public class DentistaJacoboAP {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dentista", nullable = false)
	@EqualsAndHashCode.Include
	private int idDentista;
	
	
	@Column(name = "cop", nullable = false)
	private String cop;
	
	@Column(name = "nombre_completo", nullable = false)
	private String nombreCompleto;
	
	@Column(name = "fecha_inicio_contrato", nullable = false)
	private Date fechaIniCont;
	
	@Column(name = "turno", nullable = false)
	private String turno;
	
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_especialidad", nullable = true )
    private EspecialidadJacoboAP especialidad;
	

	@Override
	public String toString() {
	    return nombreCompleto;
	}
	
    public DentistaJacoboAP(String cop, String nombreCompleto, Date fechaIniCont, String turno, String correo, EspecialidadJacoboAP especialidad) {
        this.cop = cop;
        this.nombreCompleto = nombreCompleto;
		this.fechaIniCont = new Date();
		this.turno = turno;
		this.correo = correo;
        this.especialidad = especialidad;

    }
}