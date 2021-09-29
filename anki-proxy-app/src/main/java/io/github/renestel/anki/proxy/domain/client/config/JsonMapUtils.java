package io.github.renestel.anki.proxy.domain.client.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonMapUtils {
    public static List<Map<String, Object>> toList(Object source) {
        if (source == null) {
            return Collections.emptyList();
        }
        return (List<Map<String, Object>>) source;
    }

    public static Map<String, Object> toMap(Object source) {
        if (source == null) {
            return Collections.emptyMap();
        }
        return (Map<String, Object>) source;
    }

    public static List<String> toStringList(Object source) {
        return (List<String>) source;
    }
}
