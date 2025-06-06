package dados;

public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private Usuario usuarioLogado;

    private SessaoUsuario() {
        // Construtor privado para impedir instancias diretas
    }

    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public Usuario getUsuario() {
        return usuarioLogado;
    }

    public void encerrarSessao() {
        usuarioLogado = null;
    }
}

   //SessaoUsuario.getInstancia().setUsuario(usuario);