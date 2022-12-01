package ifsp.projeto.poo.model;

public abstract class Usuario {

    private Integer id;
    private String nome;
    protected String login;
    protected String senha;
    protected String telefone;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, String telefone) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(Integer id, String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //USAREMOS ESSES 2 METODOS PARA APLICAR A HERANÇA E O POLIMORFISMO
    //NA CLASSE FUNCIONARIO E ADMINISTRADOR

    public void cadastarUsuario(Usuario usuario) {
    }

    public boolean login(String login, String senha) {
        return false;
    }


}