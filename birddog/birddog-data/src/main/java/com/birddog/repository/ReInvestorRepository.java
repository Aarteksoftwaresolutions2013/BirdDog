package com.birddog.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.ReInvestor;

/**
 * 
 * @author Aartek
 *
 */
public interface ReInvestorRepository extends JpaRepository<ReInvestor, Integer> {

    ReInvestor findByEmail(String userName);

    ReInvestor findById(Integer id);

    @Modifying
    @Transactional
    @Query("update ReInvestor r set r.name = ?2 ,r.contactNo = ?3,r.address.id = ?4 where r.id = ?1")
    void updateReInvester(Integer reInvestorId, String name, String contactNo, Integer addressId);

    @Modifying
    @Transactional
    @Query("update ReInvestor img set img.imageName = ?2 where img.id = ?1")
    void updateByReInvestorId(Integer id, String imageName);

    List<ReInvestor> findByIsDeleted(int zero);

    @Query(value = "SELECT r FROM ReInvestor r WHERE r.name like ?1")
    List<ReInvestor> findByFirstnameStartingWith(String serach);

    @Query(value = "SELECT r FROM ReInvestor r WHERE r.creationTime Between ?1 and ?2")
    List<ReInvestor> findByCreationDateBetween(Date fromdate, Date todate);

}
