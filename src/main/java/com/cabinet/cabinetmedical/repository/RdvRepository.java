package com.cabinet.cabinetmedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cabinet.cabinetmedical.entity.Rdv;

public interface RdvRepository extends CrudRepository<Rdv, Long> {
	
	 @Query(value = "SELECT * FROM rdv WHERE (iduser = ?1) ", nativeQuery = true)
	    List<Rdv> findAllRdvByUserID(Long id);
	 
	 @Query(value = "SELECT * FROM `rdv` WHERE (`iduser` = ?1) AND (`date` >= ?2 )", nativeQuery = true)
	    List<Rdv> findAllRdvByUserIDAndDate(Long id, String date);
	 
	 @Query(value = "SELECT * FROM `rdv` WHERE (`iduser` = ?1) AND (`date` < ?2 )", nativeQuery = true)
	    List<Rdv> findAllRdvHistory(Long id, String date);
	 
	 @Query(value = "SELECT * FROM rdv WHERE (date = ?1) ", nativeQuery = true)
	    List<Rdv> findRdvsByDate(String date);
	 
	 void deleteRdvById(long id);
	 
	 @Query(value = "SELECT `iduser` FROM rdv WHERE (`id` = ?1) ", nativeQuery = true)
	    long findUserIdByRdvId( long idRdv);
	 
	 @Query(value = "INSERT INTO `rdv` "
	 		+ "(`id`, `date`, `isAvailable`, `startingHour`, `finishingHour`, `idUser`) "
	 		+ "VALUES (NULL, ?1, '0', ?2, ?3, ?4);", nativeQuery = true)
	    void addrdv( String date, int startingHour, int finishingHour, long idUser );
	
}
