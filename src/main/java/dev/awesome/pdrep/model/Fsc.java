package dev.awesome.pdrep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REFFSC")
public class Fsc {
	@Id
	@Column(name="FSC")
	private String fsc;
	
	@Column(name = "FSC_MATERIAL_DESCRIPTION")
	private String description;

	public String getFsc() {
		return fsc;
	}

	public void setFsc(String fsc) {
		this.fsc = fsc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Fsc [fsc=" + fsc + ", description=" + description + "]";
	}
	
}
