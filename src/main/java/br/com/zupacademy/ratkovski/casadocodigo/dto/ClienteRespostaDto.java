package br.com.zupacademy.ratkovski.casadocodigo.dto;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Cliente;

/**classe para retornar somente o id**/


public class ClienteRespostaDto {
	
	private Long id;

	public Long getId() {
		return this.id;
	}

	public ClienteRespostaDto(Long id) {
		this.id = id;
	}



	
	public static ClienteRespostaDto toModel(Cliente cliente) {
		return new ClienteRespostaDto(cliente.getId());
	}
}
