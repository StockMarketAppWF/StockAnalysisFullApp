package com.wellsfargo.sectorservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.sectorservice.models.Sector;
public interface SectorRepository extends JpaRepository<Sector, Integer> {

}