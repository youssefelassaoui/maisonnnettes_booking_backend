package maisonnettes.booking.maisonnettes_booking.Repositories;

import maisonnettes.booking.maisonnettes_booking.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
