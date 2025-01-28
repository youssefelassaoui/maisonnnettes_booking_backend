package maisonnettes.booking.maisonnettes_booking.Repositories;

import maisonnettes.booking.maisonnettes_booking.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
