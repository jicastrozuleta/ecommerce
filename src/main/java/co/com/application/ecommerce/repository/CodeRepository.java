package co.com.application.ecommerce.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.application.ecommerce.model.Code;

public interface CodeRepository extends JpaRepository<Code, Long> {

	@Query("SELECT c FROM Code c WHERE c.username =:username AND c.idUsuario =:idUser AND c.codeNumber =:numCode")
	public Optional<Code> validateCode(@Param("username") String username, @Param("idUser") Long idUsername,
			@Param("numCode") int numberCode);

	@Transactional
	@Modifying
	@Query("DELETE FROM Code c WHERE c.username =:username")
	public void removeOthers(@Param("username") String username);
}
