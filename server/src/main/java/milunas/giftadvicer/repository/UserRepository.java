package milunas.giftadvicer.repository;

import milunas.giftadvicer.model.UserAccount;
//mport org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository /*extends JpaRepository<UserAccount, Long>*/ {
    UserAccount findUserByName(String name);
}
