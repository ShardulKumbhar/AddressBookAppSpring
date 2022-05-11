package repository;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdderssBookRepository extends JpaRepository<AddressbookData,Integer> {
}