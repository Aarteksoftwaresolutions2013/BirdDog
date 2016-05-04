package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Aartek
 */
@Entity
@Table(name = "lead")
public class Lead {

    private Integer id;
    private Address address;
    private Birddog birddog;
   
    private String propertyType;
    private String status;
    private int isDeleted;
    private Date creationTime;
    private Date updationTime;
    private String ownerFirstName;
    private String ownerLastName;
    private String constructionType;
    private String roofConstructionType;
    private String sqFootUnderAir;
    private String pool;
    private String sqFootageUnderAir;
    private String builtyear;
    private String numberOfOBedrooms;
    private String numberOfBathRooms;
    private String lastSaleDate;
    private String lastDatePrice;
    private String propertyLeadType;
    private String ownerVerification;
    private String sellerMotivation;
    private String physicalPropertyIndicators;
    private String personalIndicators;
    private String driveByDate;
    private String verifyOccupancy;
    private String notListedWithRealtor;
    private String notListedAnyTypeAuctions;
    private String verifyPropertyOwnerIsPersion;
    private String fromDate;
	private String toDate;
	private String search;
	private String approval;
	private String comment;
	private String approvalStatusColour;
	private String checkLastSaleDate,checkLastSalePrice,checkMotivation,checkPhyIndicators,checkPerIndicators,checkDrive;

	@Transient
    public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Lead() {
    }

    public Lead(Address address, Birddog birddog, String propertyType, String status, int isDeleted,
                    Date creationTime, Date updationTime, String ownerFirstName, String ownerLastName,
                    String constructionType, String roofConstructionType, String sqFootUnderAir, String pool,
                    String sqFootageUnderAir, String builtyear, String numberOfOBedrooms, String numberOfBathRooms,
                    String lastSaleDate, String lastDatePrice, String propertyLeadType, String ownerVerification,
                    String sellerMotivation, String physicalPropertyIndicators, String personalIndicators,
                    String driveByDate, String verifyOccupancy, String notListedWithRealtor,
                    String notListedAnyTypeAuctions, String verifyPropertyOwnerIsPersion, String approval,String commnet) {
        this.address = address;
        this.birddog = birddog;
     
        this.propertyType = propertyType;
        this.status = status;
        this.isDeleted = isDeleted;
        this.creationTime = creationTime;
        this.updationTime = updationTime;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.constructionType = constructionType;
        this.roofConstructionType = roofConstructionType;
        this.sqFootUnderAir = sqFootUnderAir;
        this.pool = pool;
        this.sqFootageUnderAir = sqFootageUnderAir;
        this.builtyear = builtyear;
        this.numberOfOBedrooms = numberOfOBedrooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.lastSaleDate = lastSaleDate;
        this.lastDatePrice = lastDatePrice;
        this.propertyLeadType = propertyLeadType;
        this.ownerVerification = ownerVerification;
        this.sqFootageUnderAir = sqFootageUnderAir;
        this.sellerMotivation = sellerMotivation;
        this.physicalPropertyIndicators = physicalPropertyIndicators;
        this.personalIndicators = personalIndicators;
        this.driveByDate = driveByDate;
        this.verifyOccupancy = verifyOccupancy;
        this.notListedWithRealtor = notListedWithRealtor;
        this.notListedAnyTypeAuctions = notListedAnyTypeAuctions;
        this.verifyPropertyOwnerIsPersion = verifyPropertyOwnerIsPersion;
        this.approval=approval;
        this.comment=comment;
    }
    
   @Transient
    public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	@Transient
	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Lead(Address address, Birddog birddog, String propertyType, String status, int isDeleted,
                    Date creationTime, Date updationTime, Set<Payment> payments, Set<Comment> comments,
                    Set<Attachment> attachments, String ownerFirstName, String ownerLastName, String constructionType,
                    String roofConstructionType, String sqFootUnderAir, String pool, String sqFootageUnderAir,
                    String builtyear, String numberOfOBedrooms, String numberOfBathRooms, String lastSaleDate,
                    String lastDatePrice, String propertyLeadType, String ownerVerification, String sellerMotivation,
                    String physicalPropertyIndicators, String personalIndicators, String driveByDate,
                    String verifyOccupancy, String notListedWithRealtor, String notListedAnyTypeAuctions,
                    String verifyPropertyOwnerIsPersion,String approval,String comment) {
        this.address = address;
        this.birddog = birddog;
        this.propertyType = propertyType;
        this.status = status;
        this.isDeleted = isDeleted;
        this.creationTime = creationTime;
        this.updationTime = updationTime;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.constructionType = constructionType;
        this.roofConstructionType = roofConstructionType;
        this.sqFootUnderAir = sqFootUnderAir;
        this.pool = pool;
        this.sqFootageUnderAir = sqFootageUnderAir;
        this.builtyear = builtyear;
        this.numberOfOBedrooms = numberOfOBedrooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.lastSaleDate = lastSaleDate;
        this.lastDatePrice = lastDatePrice;
        this.propertyLeadType = propertyLeadType;
        this.ownerVerification = ownerVerification;
        this.sqFootageUnderAir = sqFootageUnderAir;
        this.sellerMotivation = sellerMotivation;
        this.physicalPropertyIndicators = physicalPropertyIndicators;
        this.personalIndicators = personalIndicators;
        this.driveByDate = driveByDate;
        this.verifyOccupancy = verifyOccupancy;
        this.notListedWithRealtor = notListedWithRealtor;
        this.notListedAnyTypeAuctions = notListedAnyTypeAuctions;
        this.verifyPropertyOwnerIsPersion = verifyPropertyOwnerIsPersion;
        this.approval=approval;
        this.comment=comment;
    }

	 @Column(name = "COMMENT")
    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
  
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BIRDDOG_ID")
    public Birddog getBirddog() {
        return this.birddog;
    }

    public void setBirddog(Birddog birddog) {
        this.birddog = birddog;
    }

    @Column(name = "PROPERTY_TYPE", length = 80)
    public String getPropertyType() {
        return this.propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Column(name = "STATUS", nullable = false, length = 50)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "IS_DELETED", nullable = false)
    public int getIsDeleted() {
        return this.isDeleted;
    }

    @Column(name = "APPROVAL", nullable = false, length = 50)
	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}
    
    
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_TIME", nullable = false, length = 19)
    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATION_TIME", nullable = false, length = 19)
    public Date getUpdationTime() {
        return this.updationTime;
    }

    public void setUpdationTime(Date updationTime) {
        this.updationTime = updationTime;
    }

    @Column(name = "OWNER_FIRST_NAME")
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    @Column(name = "OWNER_LAST_NAME")
    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    @Column(name = "CONSTRUCTION_TYPE")
    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    @Column(name = "ROOF_CONSTRUCTION_TYPE")
    public String getRoofConstructionType() {
        return roofConstructionType;
    }

    public void setRoofConstructionType(String roofConstructionType) {
        this.roofConstructionType = roofConstructionType;
    }

    @Column(name = "SQ_FOOT_UNDER_AIR")
    public String getSqFootUnderAir() {
        return sqFootUnderAir;
    }

    public void setSqFootUnderAir(String sqFootUnderAir) {
        this.sqFootUnderAir = sqFootUnderAir;
    }

    @Column(name = "POOL")
    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    @Column(name = "SQ_FOOTAGE_UNDER_AIR")
    public String getSqFootageUnderAir() {
        return sqFootageUnderAir;
    }

    public void setSqFootageUnderAir(String sqFootageUnderAir) {
        this.sqFootageUnderAir = sqFootageUnderAir;
    }

    @Column(name = "BUILT_YEAR")
    public String getBuiltyear() {
        return builtyear;
    }

    public void setBuiltyear(String builtyear) {
        this.builtyear = builtyear;
    }

    @Column(name = "NO_BEDROOMS")
    public String getNumberOfOBedrooms() {
        return numberOfOBedrooms;
    }

    public void setNumberOfOBedrooms(String numberOfOBedrooms) {
        this.numberOfOBedrooms = numberOfOBedrooms;
    }

    @Column(name = "NO_BATHROOMS")
    public String getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public void setNumberOfBathRooms(String numberOfBathRooms) {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    @Column(name = "LAST_SALE_DATE")
    public String getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(String lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    @Column(name = "LAST_SALES_PRICE")
    public String getLastDatePrice() {
        return lastDatePrice;
    }

    public void setLastDatePrice(String lastDatePrice) {
        this.lastDatePrice = lastDatePrice;
    }

    @Column(name = "PROPERTY_LEAD_TYPE")
    public String getPropertyLeadType() {
        return propertyLeadType;
    }

    public void setPropertyLeadType(String propertyLeadType) {
        this.propertyLeadType = propertyLeadType;
    }

    @Column(name = "OWNER_VERIFICATION")
    public String getOwnerVerification() {
        return ownerVerification;
    }

    public void setOwnerVerification(String ownerVerification) {
        this.ownerVerification = ownerVerification;
    }

    @Column(name = "SELLER_MOTIVATION")
    public String getSellerMotivation() {
        return sellerMotivation;
    }

    public void setSellerMotivation(String sellerMotivation) {
        this.sellerMotivation = sellerMotivation;
    }

    @Column(name = "PHYSICAL_PROPERTY_INDICATORS")
    public String getPhysicalPropertyIndicators() {
        return physicalPropertyIndicators;
    }

    public void setPhysicalPropertyIndicators(String physicalPropertyIndicators) {
        this.physicalPropertyIndicators = physicalPropertyIndicators;
    }

    @Column(name = "PERSONAL_INDICATORS")
    public String getPersonalIndicators() {
        return personalIndicators;
    }

    public void setPersonalIndicators(String personalIndicators) {
        this.personalIndicators = personalIndicators;
    }

    @Column(name = "DRIVE_BY_DATE")
    public String getDriveByDate() {
        return driveByDate;
    }

    public void setDriveByDate(String driveByDate) {
        this.driveByDate = driveByDate;
    }

    @Column(name = "VERIFY_OCCUPANCY")
    public String getVerifyOccupancy() {
        return verifyOccupancy;
    }

    public void setVerifyOccupancy(String verifyOccupancy) {
        this.verifyOccupancy = verifyOccupancy;
    }

    @Column(name = "NOTLISTED_WITH_REALTOR")
    public String getNotListedWithRealtor() {
        return notListedWithRealtor;
    }

    public void setNotListedWithRealtor(String notListedWithRealtor) {
        this.notListedWithRealtor = notListedWithRealtor;
    }

    @Column(name = "NOTLISTED_ANY_TYPE_AUCTIONS")
    public String getNotListedAnyTypeAuctions() {
        return notListedAnyTypeAuctions;
    }

    public void setNotListedAnyTypeAuctions(String notListedAnyTypeAuctions) {
        this.notListedAnyTypeAuctions = notListedAnyTypeAuctions;
    }

    @Column(name = "VIRIFY_PROPERTY_OWNER_ISPERSON")
    public String getVerifyPropertyOwnerIsPersion() {
        return verifyPropertyOwnerIsPersion;
    }

    public void setVerifyPropertyOwnerIsPersion(String verifyPropertyOwnerIsPersion) {
        this.verifyPropertyOwnerIsPersion = verifyPropertyOwnerIsPersion;
    }

    @Transient
    public String getApprovalStatusColour() {
        return approvalStatusColour;
    }

    public void setApprovalStatusColour(String approvalStatusColour) {
        this.approvalStatusColour = approvalStatusColour;
    }

    @Column(name = "CHECK_LAST_SALE_DATE")
    public String getCheckLastSaleDate() {
        return checkLastSaleDate;
    }

    public void setCheckLastSaleDate(String checkLastSaleDate) {
        this.checkLastSaleDate = checkLastSaleDate;
    }

    @Column(name = "CHECK_MOTIVATION")
    public String getCheckMotivation() {
        return checkMotivation;
    }

    public void setCheckMotivation(String checkMotivation) {
        this.checkMotivation = checkMotivation;
    }

    @Column(name = "CHECK_PHY_INDICATORS")
    public String getCheckPhyIndicators() {
        return checkPhyIndicators;
    }

    public void setCheckPhyIndicators(String checkPhyIndicators) {
        this.checkPhyIndicators = checkPhyIndicators;
    }

    @Column(name = "CHECK_PER_INDICATORS")
    public String getCheckPerIndicators() {
        return checkPerIndicators;
    }

    public void setCheckPerIndicators(String checkPerIndicators) {
        this.checkPerIndicators = checkPerIndicators;
    }

    @Column(name = "CHECK_DRIVE")
    public String getCheckDrive() {
        return checkDrive;
    }

    public void setCheckDrive(String checkDrive) {
        this.checkDrive = checkDrive;
    }

    @Column(name = "CHECK_LAST_SALE_PRICE")
    public String getCheckLastSalePrice() {
        return checkLastSalePrice;
    }

    public void setCheckLastSalePrice(String checkLastSalePrice) {
        this.checkLastSalePrice = checkLastSalePrice;
    }

}
