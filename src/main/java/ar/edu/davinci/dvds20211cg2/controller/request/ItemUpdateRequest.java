package ar.edu.davinci.dvds20211cg2.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemUpdateRequest {

	private Integer cantidad;
	
}

