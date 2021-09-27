package app.io.github.renestel.notion.proxy.client.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEnum {
    TITLE("title"),
    SELECT("select"),
    RICH_TEXT("rich_text"),
    MULTI_SELECT("multi_text"),
    FORMULA("formula");

    String name;
}
