package dev.awesome.pdrep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.awesome.pdrep.model.Fsc;
import dev.awesome.pdrep.repository.FscRepository;

@SpringBootApplication
public class SpringJpaOracleConnApplication implements CommandLineRunner {

	@Autowired
	private FscRepository fscRepo;

//	public static void main (String[] args) {
//		SpringApplication.run(SpringJpaOracleConnApplication.class, args);
//	}
	
	@Override
	public void run(String... args) throws Exception {
//		List<Fsc> fscs = fscRepo.findAll();
//		
//		fscs.forEach(System.out :: println);		
	}
	
}
