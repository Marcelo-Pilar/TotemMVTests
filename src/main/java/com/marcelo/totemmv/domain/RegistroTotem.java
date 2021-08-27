package com.marcelo.totemmv.domain;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RegistroTotem implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@OneToMany
	private List<FilaSenha> filaSenha;
	
	
	@Column(nullable = false, length = 30, unique = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@Column(nullable = false, length = 30, unique = false)	
	private String empresa;

	@Column(nullable = false, length = 30, unique = true)
	private String nomeTotem;
	
	@Column(nullable = false, length = 30, unique = false)
	private String origem;
	
	@Column(nullable = false, length = 30, unique = false)
	private String nomeImpressora;
	
	@Column(nullable = false, length = 30, unique = false)	
	private String modeloImpressora;
	
	@Column(nullable = false, length = 30, unique = false)
	private String tipoImpressao;

	@Column(nullable = false, length = 30, unique = false)
	private String nomeComputador;

	@Column(nullable = false, length = 30, unique = false)
	private String prestador;

	@Column(nullable = false, length = 30, unique = false)
	private String setor;

	@Column(nullable = false, length = 30, unique = false)
	private Integer avancoPapel;
	
	@Column(nullable = true, length = 30, unique = false)
	private Boolean leitorCodigo;
	
	@Column(nullable = false, length = 30, unique = false)
	private String usuario;	
	
	public RegistroTotem() {
		super();

	}

	public RegistroTotem(Long id,LocalDate dataCadastro, String empresa, String nomeTotem, String origem,
			String nomeImpressora, String modeloImpressora, String tipoImpressao, String nomeComputador,
			String prestador, String setor, Integer avancoPapel, String usuario, List<FilaSenha> filaSenha) {
		super();
		this.id = id;
		this.filaSenha = filaSenha;
		this.dataCadastro = dataCadastro;
		this.empresa = empresa;
		this.nomeTotem = nomeTotem;
		this.origem = origem;
		this.nomeImpressora = nomeImpressora;
		this.modeloImpressora = modeloImpressora;
		this.tipoImpressao = tipoImpressao;
		this.nomeComputador = nomeComputador;
		this.prestador = prestador;
		this.setor = setor;
		this.avancoPapel = avancoPapel;
		this.usuario = usuario;
	}

	public List<FilaSenha> getFilaSenha() {
		return filaSenha;
	}

	public void setFilaSenha(List<FilaSenha> filaSenha) {
		this.filaSenha = filaSenha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNomeTotem() {
		return nomeTotem;
	}

	public void setNomeTotem(String nomeTotem) {
		this.nomeTotem = nomeTotem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getNomeImpressora() {
		return nomeImpressora;
	}

	public void setNomeImpressora(String nomeImpressora) {
		this.nomeImpressora = nomeImpressora;
	}

	public String getModeloImpressora() {
		return modeloImpressora;
	}

	public void setModeloImpressora(String modeloImpressora) {
		this.modeloImpressora = modeloImpressora;
	}

	public String getTipoImpressao() {
		return tipoImpressao;
	}

	public void setTipoImpressao(String tipoImpressao) {
		this.tipoImpressao = tipoImpressao;
	}

	public String getNomeComputador() {
		return nomeComputador;
	}

	public void setNomeComputador(String nomeComputador) {
		this.nomeComputador = nomeComputador;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Integer getAvancoPapel() {
		return avancoPapel;
	}

	public void setAvancoPapel(Integer avancoPapel) {
		this.avancoPapel = avancoPapel;
	}

	public Boolean getLeitorCodigo() {
		return leitorCodigo;
	}

	public void setLeitorCodigo(Boolean leitorCodigo) {
		this.leitorCodigo = leitorCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroTotem other = (RegistroTotem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
