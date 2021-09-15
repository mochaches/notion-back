package io.github.renestel.notion.back.app;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {
    private final ModelMapper mapper;

    @GetMapping
    public String some() {
        var sourceDto = new SourceDto();
        sourceDto.setId(1l);
        var map = mapper.map(sourceDto, DestinationDto.class);
        return null;
    }
}
