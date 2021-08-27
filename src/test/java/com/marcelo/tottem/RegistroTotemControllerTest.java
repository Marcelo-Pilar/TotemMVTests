package com.marcelo.tottem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.marcelo.totemmv.controller.RegistroTotemController;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(controllers = RegistroTotemController.class)
public class RegistroTotemControllerTest {


	@Autowired
	MockMvc mockMvc;
	
//	@MockBean
//	private RegistroTotem registroTotem;
	
//	@Autowired
//	private ObjectMapper objectMapper;
//	
//	@Test
//	public void httpTest() throws Exception {
//		mockMvc.perform(post("/registroTotem")
//			    .contentType("application/json"))
//			    .andExpect(status().isOk());
//	}
	
	@Test
	public void testeRegistroTotemgetAll() throws Exception {
		mockMvc.perform(get("/registroTotem"))
		.andExpect(status().isOk());
	}
//	
//	@Test
//	public void testeRegistroTotemSave() throws Exception {
//		
//		
//		ArrayList<FilaSenha> agenda = new ArrayList();
//		   agenda.add("Juca Bala;11 1111-1111");
//		    agenda.add("Marcos Paqueta;22 2222-2222");
//		    agenda.add("Maria Antonieta;33 3333-3333");
//		    agenda.add("Antônio Conselheiro;44 4444-4444");
//		
//		int[][] array1 = { { 1,2,3 }, { 4, 5, 6 } };
//		//Construtor contrutor = new Construtor(parametros)
//		RegistroTotem registroTotem = new RegistroTotem(1, "20/10/2020", "UNIMED", "Totem Recepção", "Emergência", "HP 710 UNIMED", "HP 710", "Rascunho", "PC Recepção","Dr Carlos", "Urgência", 1, "Marcelo", agenda );
//		
//		mockMvc.perform(post("/registroTotem/{registroTotemId}")
//		.contentType("application/json")
//		.content(objectMapper.writeValueAsString(registroTotem)))
//		.andExpect(status().isOk());
//	}
	

}
