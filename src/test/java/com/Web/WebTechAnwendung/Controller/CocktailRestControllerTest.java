package com.Web.WebTechAnwendung.Controller;

import com.Web.WebTechAnwendung.api.Cocktail;
import com.Web.WebTechAnwendung.api.CocktailRestController;
import com.Web.WebTechAnwendung.service.CocktailService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CocktailRestController.class)
class CocktailRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CocktailService cocktailService;

    @Test
    @DisplayName("should return found coktail from coktail service")
    void should_return_cocktail_from_cocktail_service() throws Exception {
        // given
        var cocktails = List.of(
          new Cocktail(2,"lecker","Beach","Vodka","sanft"),
          new Cocktail(3,"einzigartig", "Summer","Rum","weich")
        );
        doReturn(cocktails).when(cocktailService).findAll();

        // when
        mockMvc.perform(get("/cocktails"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].rezept").value("lecker"))
                .andExpect(jsonPath("$[0].name").value("Beach"))
                .andExpect(jsonPath("$[0].zutaten").value("Vodka"))
                .andExpect(jsonPath("$[0].tags").value("sanft"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].rezept").value("einzigartig"))
                .andExpect(jsonPath("$[1].name").value("Summer"))
                .andExpect(jsonPath("$[1].zutaten").value("Rum"))
                .andExpect(jsonPath("$[1].tags").value("weich"));
    }

    @Test
    @DisplayName("should return 404 if cocktail is not found")
    void should_return_404_if_cocktail_is_not_found() throws Exception {
        // given
        doReturn(null).when(cocktailService).findById(anyLong());

        // when
        mockMvc.perform(get("/cocktails/404"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a new Cocktail")
    void should_return_201_http_status_and_location_header_when_creating_a_cocktail() throws Exception {
        // given
        String cocktailToCreateAsJson = "{\"rezept\": \"lecker\", \"name\":\"Beach\", \"zutaten\":\"Vodka\", \"tags\": \"sanft\"}";
        var cocktail = new Cocktail(123, null, null, null, null);
        doReturn(cocktail).when(cocktailService).create(any());

        // when
        mockMvc.perform(
                        post("/cocktails")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(cocktailToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/cocktails/" + cocktail.getId()))));

    }

    /*@Test
    @DisplayName("should validate create cocktail request")
    void should_validate_create_cocktail_request() throws Exception {
        // given
       String cocktailToCreateAsJson = "{\"rezept\": \"a\", \"name\":\"\", \"zutaten\":\"Vodka\", \"tags\": \"sanft\"}";
        // when
        mockMvc.perform(
                        post("/cocktails")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(cocktailToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());

     */
    }

