package com.phong.mvc.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity   // This means that it is related to a database
@Table(name="language")  // This is the tablename in the DB
public class Language {
	
	// GENERATES FIELD NAMES IN MYSQL DB WITH CONSTRAINTS  
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto-generates the ID
    private Long id;
    
    @Size(min = 5, max = 20)
    private String languageName;
    
    @Size(min = 2, max = 20)
    private String creator;
    
    @Min(1)
    private String currentVersion;
    
 
    
    // THIS PREVENTS THE CREATED_AT FIELD FROM BEING UPDATED AFTER CREATION 
    @Column(updatable=false)    // Created at date does not change with every save
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    // CONSTRUCTOR METHOD
    public Language() {
    	
    }
    
    public Language(String languageName, String creator, String currentVersion) {
		this.languageName = languageName;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}

    // GETTERS AND SETTERS FOR EACH FIELD IN TABLE
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getlanguageName() {
		return languageName;
	}
	public void setlanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getcreator() {
		return creator;
	}
	public void setcreator(String creator) {
		this.creator = creator;
	}
	public String getcurrentVersion() {
		return currentVersion;
	}
	public void setcurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

//	public Language(String langName, String creator, String currentVer) {
//        this.languageName = langName;
//        this.creator = creator;
//        this.currentVersion = currentVer;
//    }
    
    
    // means before a save, it must save the created at date.
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
 // means before a save, it must save the updated at date.
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}