
package com.wellsfargo.sector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.wellsfargo.sector.models.Sector;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Integer> {

}
