package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upload_pdfandsoftware")
public class UploadPdf {

    private Integer id;
    private String title;
    private String description;
    private String name;
    private int roleId;
    private String type;
    private int isDeleted;
    private String fileType;

    public UploadPdf() {
    }

    public UploadPdf(String title, String description, String name, Integer roleId, String fileType) {

        this.title = title;
        this.description = description;
        this.name = name;
        this.roleId = roleId;
        this.fileType=fileType;

    }
    @Column(name = "FILE_TYPE")
    public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "IS_DELETED")
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Column(name = "ROLE")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PDF_NAME")
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

}
