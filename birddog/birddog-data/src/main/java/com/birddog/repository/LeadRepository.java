package com.birddog.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.birddog.model.Lead;

/**
 * 
 * @author Aartek
 *
 */
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    List<Lead> findByBirddogReInvestorId(Integer reiId);

    List<Lead> findByBirddogId(Integer id);

    List<Lead> findByBirddogReInvestorIdAndIsDeleted(Integer reiId, int zero);

    List<Lead> findByBirddogIdAndIsDeleted(Integer id, int zero);

    @Query(value = "SELECT l FROM Lead l WHERE l.creationTime Between ?1 and ?2")
    List<Lead> findByCreationDateBetween(Date fromdate, Date todate);

    @Query(value = "SELECT l FROM Lead l WHERE l.birddog.name like ?1")
    List<Lead> findByFirstnameStartingWith(String search);

   /* @Query(value = "SELECT l FROM Lead l WHERE l.birddog.id=?1 AND l.approval=?4 AND l.creationTime Between ?2 AND ?3")
    List<Lead> findByBirddogIdAndDateRange(Integer id, Date fromDate, Date toDate,String approval);*/

    @Query(value = "SELECT l FROM Lead l WHERE l.birddog.id=?1 AND l.status=?4 AND l.creationTime Between ?2 AND ?3")
    List<Lead> findByBirddogIdAndDateRangeAndStatus(Integer id, Date dateBeforeThirtyDays, Date todayDate,
                    String propertyClosedOn);

	List<Lead> findByBirddogReInvestorIdAndBirddogNameAndIsDeleted(Integer id, String name, int zero);

	Lead findById(Integer id, int zero);

	List<Lead> findByBirddogReInvestorIdAndAddressCityIdAndIsDeleted(Integer id, Integer cityId, int zero);

	@Query(value = "SELECT l FROM Lead l WHERE l.birddog.id=?1 AND l.approval=?4 AND l.status=?5 AND l.creationTime Between ?2 AND ?3")
	List<Lead> findByBirddogIdAndDateRange(Integer id, Date fromDate, Date toDate, String approval,
					String success);


}
