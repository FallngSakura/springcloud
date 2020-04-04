package club.fallngsakura.springcloud.entities;


import lombok.*;

import java.io.Serializable;

/**
 * @author MISAKI RINNE
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    @Getter @Setter private  Long id;

    @Getter @Setter private String serial;
}
