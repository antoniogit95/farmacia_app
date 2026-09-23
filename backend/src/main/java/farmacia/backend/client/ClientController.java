package farmacia.backend.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {
    
    private final ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody ClientRequest request ){
        return clientService.save(request);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> getClient(){
        return clientService.getAllClient();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> clientUpdate(@PathVariable Long id, @RequestBody ClientRequest request){
        return clientService.update(id, request);
    }
}
