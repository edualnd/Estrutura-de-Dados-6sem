package eduarda.atividades.listaligada.circular.lista11.atividade04;

public class NoLivro {
    private NoLivro proximo;
    private NoLivro anterior;

    String autor;
    String titulo;
    String edicao;
    String local;
    String editora;
    int ano;

    public NoLivro(String autor, String titulo, String edicao, String local, String editora, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.edicao = edicao;
        this.local = local;
        this.editora = editora;
        this.ano = ano;

        this.proximo = null;
        this.anterior = null;
    }

    public NoLivro getProximo() {
        return proximo;
    }

    public void setProximo(NoLivro proximo) {
        this.proximo = proximo;
    }

    public NoLivro getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLivro anterior) {
        this.anterior = anterior;
    }
}
