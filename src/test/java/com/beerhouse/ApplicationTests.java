package com.beerhouse;

import com.beerhouse.controller.BeerController;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BeerController.class, secure = false)
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BeerRepository beerRepository;

	@Test
	public void findAllTest() throws Exception{
		Beer beer = new Beer();
		beer.setName("teste unitario");
		beer.setCategory("alcolico teste");
		beer.setAlcoholContent("4 percent");
		beer.setIngredients("cevada");
		beer.setPrice(3);
		beer.setId(1);


		given(beerRepository.findById(beer.getId())).willReturn(Optional.of(beer));

		mockMvc.perform(get("http://localhost:9000//beerhouse/beers/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}


}