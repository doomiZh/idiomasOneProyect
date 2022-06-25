package pe.com.pi.idiomasone.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.pi.idiomasone.model.Contactos;

@Repository
public interface ContactosRepository extends JpaRepository<Contactos, Long>{

}

