package targil.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private FinancialInfo financialInfo;
    private PersonalInfo personalInfo;
}
