package com.beautiful.shop.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository -> uputa Springu da on kreirao po šablonu ovog interfejsa
 * neku implementaciju njegovu i nama da na korištenje kada nam zatreba.
 * <p>
 * @Autowired
 * private UserRepository userRepository;
 *
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
