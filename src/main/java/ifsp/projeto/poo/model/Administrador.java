package ifsp.projeto.poo.model;

import ifsp.projeto.poo.model.dao.UsuarioDAO;

public class Administrador extends Usuario {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    private String cnpj;

    public Administrador(String nome, String login, String senha, String cnpj) {
        super(nome, login, senha);
        this.cnpj = cnpj;
    }

    public Administrador(String login, String senha) {
        super(login, senha);
        this.login = login;
        this.senha = senha;
    }

    public Administrador(String nome, String login, String senha, String telefone, String cnpj) {
        super(nome, login, senha, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //IMPORT DO METODOS DA CLASSE USUARIO
    @Override
    public boolean login(String login, String senha) {
        return usuarioDAO.logar(login, senha);
    }

    @Override
    public void cadastarUsuario(Usuario usuario) {
        usuarioDAO.inserir(usuario);
    }
}