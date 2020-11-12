package entidades;

public class UsuariosVo {
    private int Id;
    private String Nombre, Distrito, Correo, Password;

    public UsuariosVo(){

    }

    public UsuariosVo(int id, String nombre, String distrito, String correo, String password) {
        this.Id = id;
        this.Nombre = nombre;
        this.Distrito = distrito;
        this.Correo = correo;
        this.Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
