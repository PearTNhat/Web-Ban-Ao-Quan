//package ptithcm.entity;
//
//import java.util.Collection;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//@Entity
//public class Status {
//	@Id
//	@Column(name = "statusId")
//	private String statusId;
//
//
//	@Column(name = "name")
//	private String name;
//	
//	@ManyToOne
//	@JoinColumn(name = "statusId")
//	private Orders orders;
//
//	
//	
//	public String getStatusId() {
//		return statusId;
//	}
//
//
//	public void setStatusId(String statusId) {
//		this.statusId = statusId;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	
//}
