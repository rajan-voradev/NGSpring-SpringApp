package dev.awesome.pdrep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.awesome.pdrep.model.DummyUser;

public interface DummyUserRepo extends JpaRepository<DummyUser, Long>{

}
