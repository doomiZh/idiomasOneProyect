package pe.com.pi.idiomasone.model;

@Data
@Entity
@Table(name="tb_usuario")
public class Usuarios implements Serializable{
  
  private static final long serialVersionUID=1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String contrasena;
	
	@Email
	private String correo;
	
	private int id_rol;

}
