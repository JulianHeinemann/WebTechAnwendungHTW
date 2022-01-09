package com.Web.WebTechAnwendung.Service;

import com.Web.WebTechAnwendung.persistence.CocktailEntity;
import com.Web.WebTechAnwendung.service.CocktailTransformer;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

class CocktailTransformTest implements WithAssertions {

    private final CocktailTransformer underTest = new CocktailTransformer();

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_transform_person_entity_to_person() {
        // given
        var cocktailEntity = Mockito.mock(CocktailEntity.class);
        doReturn(4L).when(cocktailEntity).getId();
        doReturn("MarquaTraum").when(cocktailEntity).getName();
        doReturn("Wunderschön").when(cocktailEntity).getRezept();
        doReturn("4cl Vodka").when(cocktailEntity).getZutaten();

        // when
        var result = underTest.transformEntity(cocktailEntity);

        // then
        assertThat(result.getId()).isEqualTo(4L);
        assertThat(result.getName()).isEqualTo("MarquaTraum");
        assertThat(result.getRezept()).isEqualTo("Wunderschön");
        assertThat(result.getZutaten()).isEqualTo("4cl Vodka");
    }
}
