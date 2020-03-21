package pl.mzuchnik.kursspringbootpracadomowa2;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@ConfigurationProperties(
        prefix = "cost",
        ignoreUnknownFields = true
)
public class Cost {

    private BigDecimal vat;
    private BigDecimal rabat;
}
