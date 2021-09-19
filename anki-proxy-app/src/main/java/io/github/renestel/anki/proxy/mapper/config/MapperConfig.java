package io.github.renestel.anki.proxy.mapper.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j(topic = "MAPPER-CONFIG")
@RequiredArgsConstructor
public class MapperConfig {
//    @Bean
    public ModelMapper createMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper
            .getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setSkipNullEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

//        Converter<List<RowDto>, List<DeckProxyDto>> rowConverter = ctx -> {
//            var src = ctx.getSource();
//            var decksWithRows = src.stream()
//                .collect(Collectors.groupingBy(RowDto::getDeck));
//
//            var result = decksWithRows.keySet().stream()
//                .map(e -> {
//                    var rows = decksWithRows.get(e).stream().map(m -> mapper.map(m, RowProxyDto.class)).collect(Collectors.toList());
//                    return DeckProxyDto.builder()
//                        .name(e)
//                        .rows(rows)
//                        .build();
//                }).collect(Collectors.toList());
//            return result;
//        };
//
//        mapper
//            .typeMap(RowDto.class, RowProxyDto.class)
//            .addMappings(m -> m.map(RowDto::getId, RowProxyDto::setId))
//            .addMappings(m -> m.map(RowDto::getSide1, RowProxyDto::setSide1))
//            .addMappings(m -> m.map(RowDto::getSide2, RowProxyDto::setSide2))
//            .addMappings(m -> m.map(RowDto::getTags, RowProxyDto::setTags))
//            .setPostConverter(ctx -> {
//                var dst = ctx.getDestination();
//                return dst;
//            });
//        mapper
//            .typeMap(GetDatabaseInfoResponse.class, GetDecksProxyResponse.class)
//            .addMappings(m -> m.using(rowConverter).map(GetDatabaseInfoResponse::getRows, GetDecksProxyResponse::setDecks));
        return mapper;
    }
}
