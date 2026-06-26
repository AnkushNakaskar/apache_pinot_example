package com.pinot.central;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BasicConfiguration extends Configuration {
    @NotNull private final int defaultSize;


    private String baseName ="resource";


    @JsonCreator
    public BasicConfiguration(@JsonProperty("defaultSize") final int defaultSize) {
        this.defaultSize = defaultSize;
    }

    public int getDefaultSize() {
        return defaultSize;
    }

}