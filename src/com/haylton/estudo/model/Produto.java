package com.haylton.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Haylton
 */
@Table(name = "produto")
@Entity
public class Produto implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto")
    private Integer id;
    @NotNull(message = "O nome do produto não pode estar em branco")
    @NotBlank(message = "O nome do produto deve ser preenchido")
    @Length(max = 50, message = "O nome pode conter até {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Min(value = 0, message = "O valor minimo é de {value}")
    @NotNull(message = "O valor do preço deve ser preenchido")
    @Column(name = "preco", nullable = false, columnDefinition = "numeric(10,2)")
    private Double preco;
    
    @Min(value = 0, message = "A quantidade de estoque minima é de {value}")
    @NotNull(message = "A quantidade de estoque deve ser preenchida")
    @Column(name = "quantidade_estoque", nullable = false, columnDefinition = "numeric(10,2)")
    private Double quantidadeEstoque;
    
    @NotNull(message = "O nome do produto não pode estar em branco")
    @NotBlank(message = "O nome do produto deve ser preenchido")
    @Length(max = 50, message = "O nome pode conter até {max} caracteres")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_marca")
    private Marca marca;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",
            joinColumns = 
            @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_fisica","produto"})})
    private List<PessoaFisica> desejam = new ArrayList<>();
    
     @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Arquivo> arquivos = new ArrayList<>(); //eu só tenho list do obj no lado onde o relacionamento é 1 quando há composição(diamante preenchido) ou oneToMany e asseta aponta para essa classe 
     
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fornecimento",
            joinColumns =
            @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa_juridica", referencedColumnName = "id", nullable = false),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_juridica", "produto"})}
            )
    private List<PessoaJuridica> fornecimento = new ArrayList<>();
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Foto> fotos = new ArrayList<>();
    

    public Produto() {
    }
    
    public void adicionarArquivo(Arquivo arquivo){
        arquivo.setProduto(this);
        this.arquivos.add(arquivo);
    }
    
    public void removeArquivo(int index){
        this.arquivos.remove(index);
    }

    public void adicionarFoto(Foto foto ){
        foto.setProduto(this);
        this.fotos.add(foto);
    }
    
    public void removeFoto(int index){
        this.fotos.remove(index);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<PessoaFisica> getDesejam() {
        return desejam;
    }

    public void setDesejam(List<PessoaFisica> desejam) {
        this.desejam = desejam;
    }

    public List<PessoaJuridica> getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(List<PessoaJuridica> fornecimento) {
        this.fornecimento = fornecimento;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
