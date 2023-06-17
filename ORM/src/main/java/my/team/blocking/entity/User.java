package my.team.blocking.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usertab")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer uid;
	@Column(name = "uname")
	private String username;
	@Column(name = "uEmail")
	private String userEmail;
	@Column(name = "uPassword")
	private String userPassword;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="rolrs_tab",joinColumns = @JoinColumn(name="uid"))
	@Column(name = "uRoles")
	private Set<String> userRoles;

}
