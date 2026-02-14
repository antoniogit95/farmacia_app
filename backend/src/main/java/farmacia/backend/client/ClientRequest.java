package farmacia.backend.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    
    private String ci;
    private String name;
    private String surname;
    private long telefono;
    private boolean notifications;
}
