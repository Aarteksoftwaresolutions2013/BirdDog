package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.SuperAdmin;

/**
 * 
 * @author Aartek
 *
 */
public interface SuperAdminnRepository extends JpaRepository<SuperAdmin, Integer> {

    SuperAdmin findByEmail(String userName);

    SuperAdmin findById(Integer superAdminId);

    @Modifying
    @Transactional
    @Query("update SuperAdmin s set s.name = ?2 ,s.contactNo = ?3,s.address.id = ?4 where s.id = ?1")
    void updateSuperAdminProfile(Integer id, String name, String contactNo, Integer id2);

    @Modifying
    @Transactional
    @Query("update SuperAdmin simg set simg.imageName = ?2 where simg.id = ?1")
    void updateByReInvestorId(Integer id, String imageName);

    /*
     * @Modifying
     * 
     * @Transactional
     * 
     * @Query("update SuperAdmin v set v.videoName = ?2 where v.id = ?1") void updateById(Integer id, String videoName);
     */
}
