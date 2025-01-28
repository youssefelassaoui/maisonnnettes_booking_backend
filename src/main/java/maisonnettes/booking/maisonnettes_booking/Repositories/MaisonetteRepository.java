package maisonnettes.booking.maisonnettes_booking.Repositories;

import maisonnettes.booking.maisonnettes_booking.Models.Maisonette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaisonetteRepository extends JpaRepository<Maisonette, Long> {
    Optional<Maisonette> findByName(String name); // Add this method
}

