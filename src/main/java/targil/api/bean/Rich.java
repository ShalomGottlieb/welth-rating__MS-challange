package targil.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="rich")
public class Rich {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String firstName;
    private String lastName;
    private double fortune;
}
