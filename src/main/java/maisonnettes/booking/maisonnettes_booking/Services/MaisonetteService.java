package maisonnettes.booking.maisonnettes_booking.Services;

import maisonnettes.booking.maisonnettes_booking.Models.Maisonette;
import maisonnettes.booking.maisonnettes_booking.Repositories.MaisonetteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaisonetteService {

    private final MaisonetteRepository maisonetteRepository;

    public MaisonetteService(MaisonetteRepository maisonetteRepository) {
        this.maisonetteRepository = maisonetteRepository;
    }

    public List<Maisonette> getAllMaisonettes() {
        return maisonetteRepository.findAll();
    }

    public Optional<Maisonette> getMaisonetteById(Long id) {
        return maisonetteRepository.findById(id);
    }

    public Optional<Maisonette> getMaisonetteByName(String name) { // New method
        return maisonetteRepository.findByName(name);
    }

    public Maisonette createMaisonette(Maisonette maisonette) {
        return maisonetteRepository.save(maisonette);
    }

    public Maisonette updateMaisonette(Long id, Maisonette maisonetteDetails) {
        return maisonetteRepository.findById(id)
                .map(maisonette -> {
                    maisonette.setName(maisonetteDetails.getName());
                    maisonette.setMatiere(maisonetteDetails.getMatiere());
                    maisonette.setImageUrl(maisonetteDetails.getImageUrl());
                    maisonette.setPrice(maisonetteDetails.getPrice());
                    maisonette.setDescription(maisonetteDetails.getDescription());
                    return maisonetteRepository.save(maisonette);
                }).orElseThrow(() -> new RuntimeException("Maisonette not found with id: " + id));
    }

    public void deleteMaisonette(Long id) {
        maisonetteRepository.deleteById(id);
    }
}
