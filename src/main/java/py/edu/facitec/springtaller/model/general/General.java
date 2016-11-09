package py.edu.facitec.springtaller.model.general;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class General {

	@Id				//generacion automatica de id
					//dentro de la bd
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
