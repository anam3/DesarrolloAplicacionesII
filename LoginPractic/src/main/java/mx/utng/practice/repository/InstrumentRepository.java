package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.utng.practice.model.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

	@Query("select inst from Instrument inst")
	public List<Instrument>findAll();
	
}
