package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Client;
import tn.esprit.autoloc.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private IClientService clientService;

    @GetMapping
    public List<Client> retrieveAllClients() { return clientService.retrieveAllClients(); }

    @GetMapping("/{id}")
    public Client retrieveClient(@PathVariable("id") Long id) { return clientService.retrieveClient(id); }

    @PostMapping
    public Client addClient(@RequestBody Client c) { return clientService.addClient(c); }

    @PostMapping("/list")
    public List<Client> addClients(@RequestBody List<Client> clients) { return clientService.addClients(clients); }

    @PutMapping
    public Client updateClient(@RequestBody Client c) { return clientService.updateClient(c); }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable("id") Long id) { clientService.removeClient(id); }
}
