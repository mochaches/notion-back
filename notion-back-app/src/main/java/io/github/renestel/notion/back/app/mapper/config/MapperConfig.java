package io.github.renestel.notion.back.app.mapper.config;

import io.github.renestel.notion.persistence.entity.DeckEntity;
import io.github.renestel.notion.rest.gateway.api.domain.dto.DeckDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper createMapper() {
        var mapper = new ModelMapper();
        mapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        mapper
                .typeMap(DeckEntity.class, DeckDto.class)
                .addMappings(m -> m.map(DeckEntity::getId, DeckDto::setId))
                .setPostConverter(ctx -> {
                    var src = ctx.getSource();
                    var dst = ctx.getDestination();


                    return dst;
                });

        return mapper;
    }
}
