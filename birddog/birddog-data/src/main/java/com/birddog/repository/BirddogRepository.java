package com.birddog.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.Birddog;
import com.birddog.model.UploadTutorial;

/**
 * 
 * @author Aartek
 *
 */
public interface BirddogRepository extends JpaRepository<Birddog, Integer> {

    Birddog findByEmail(String userName);

    @Modifying
    @Transactional
    @Query("update Birddog b set b.name = ?2 ,b.contactNo = ?3,b.address.id = ?4 where b.id = ?1")
    void updateBirddogProfile(Integer id, String name, String contactNo, Integer birddogId);

    List<Birddog> findByReInvestorId(Integer reiId);

    @Modifying
    @Transactional
    @Query("update Birddog bimg set bimg.imageName = ?2 where bimg.id = ?1")
    void updateByBirddogId(Integer id, String imageName);

    List<Birddog> findByReInvestorIdAndIsDeleted(Integer reiId, int zero);

    @Query(value = "SELECT t FROM Birddog t WHERE t.name like ?1")
    List<Birddog> findByFirstnameStartingWith(String txtSearch);

    @Query(value = "SELECT t FROM Birddog t WHERE t.creationTime Between ?1 and ?2")
    List<Birddog> findByCreationDateBetween(Date fromDate, Date toDate);

    @Query(value = "SELECT t FROM Birddog t WHERE t.reInvestor.id=?2 and t.isDeleted=?3 and t.name like ?1")
    List<Birddog> findByReInvestorIdAndFirstnameStartingWith(String string, Integer reiId, Integer zero);

	

}
