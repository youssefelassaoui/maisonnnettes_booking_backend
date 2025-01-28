package maisonnettes.booking.maisonnettes_booking.Repositories;

import maisonnettes.booking.maisonnettes_booking.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
