package br.com.voeairlines.model;

public class TipoAeronaveDTO {
	
	private int id;           //a. Id (chave primária)

	private String descricao; //b. Descrição (String)

    public TipoAeronaveDTO() {
    	
    }
    
    public TipoAeronaveDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

    public int getId() {
    	return id;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    
    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
    
}
