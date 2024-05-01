package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Status {
	@Id
	@Column(name = "statusId")
	private String statusId;
	
	
	public Collection<Status> getStatuss() {
		return statuss;
	}


	public void setStatuss(Collection<Status> statuss) {
		this.statuss = statuss;
	}


	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "Status")
	private Collection<Status>  statuss;

	public String getStatusId() {
		return statusId;
	}


	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}
