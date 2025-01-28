package maisonnettes.booking.maisonnettes_booking.Controllers;

import maisonnettes.booking.maisonnettes_booking.Models.Maisonette;
import maisonnettes.booking.maisonnettes_booking.Services.MaisonetteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/maisonettes")
public class MaisonetteController {

    private final MaisonetteService maisonetteService;

    public MaisonetteController(MaisonetteService maisonetteService) {
        this.maisonetteService = maisonetteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maisonette> getMaisonetteById(@PathVariable Long id) {
        return maisonetteService.getMaisonetteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}") // New endpoint
    public ResponseEntity<Maisonette> getMaisonetteByName(@PathVariable String name) {
        return maisonetteService.getMaisonetteByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Maisonette createMaisonette(@RequestBody Maisonette maisonette) {
        return maisonetteService.createMaisonette(maisonette);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maisonette> updateMaisonette(@PathVariable Long id, @RequestBody Maisonette maisonetteDetails) {
        try {
            Maisonette updatedMaisonette = maisonetteService.updateMaisonette(id, maisonetteDetails);
            return ResponseEntity.ok(updatedMaisonette);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaisonette(@PathVariable Long id) {
        maisonetteService.deleteMaisonette(id);
        return ResponseEntity.noContent().build();
    }
}
