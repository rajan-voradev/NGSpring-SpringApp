package dev.awesome.pdrep.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import dev.awesome.pdrep.service.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.awesome.pdrep.exception.ResourceNotFoundException;
import dev.awesome.pdrep.model.DummyUser;
import dev.awesome.pdrep.repository.DummyUserRepo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DummyUserController {

	@GetMapping("/hidummies")
	public DummyUser hiDummies() {
		return new DummyUser("Rajan", "Vora", "rajanvora@yahoo.com");
//		throw new RuntimeException("Error from Spring API");
	}

	@GetMapping("/hidummy/{user}")
	public DummyUser hiDummy(@PathVariable String user) {
		return new DummyUser(user, user, String.format("%s@yahoo.com", user));
//		throw new RuntimeException("Error from Spring API");
	}
	
	@Autowired
	private DummyUserRepo dummyUserRepo;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DummyUserService dummyUserSrv;
	
	@GetMapping("/dummyusers")
	public List<DummyUser> getAllDummyUsers() {
		return dummyUserSrv.getAllDummyUsers();
		//return dummyUserRepo.findAll();
	}
	
	@GetMapping("/dummyuser/{id}")
//	public ResponseEntity<DummyUser> getDummyUserById(@PathVariable(value = "id") Long dummyUserId)
//        throws ResourceNotFoundException {
//        DummyUser dummyUser = dummyUserRepo.findById(dummyUserId)
//          .orElseThrow(() -> new ResourceNotFoundException("DummyUser not found for this id :: " + dummyUserId));
//        return ResponseEntity.ok().body(dummyUser);
//    }
	public ResponseEntity<DummyUser> getDummyUserById(@PathVariable(value = "id") Long dummyUserId)
			throws ResourceNotFoundException {
		System.out.println("id : "+dummyUserId);
		String sql = "SELECT id, first_name, last_name, emailid FROM dummyuser where id = " +dummyUserId;
		List<DummyUser> dummyUsers  = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DummyUser.class));
		DummyUser dummyUser = dummyUsers.get(0);
		return ResponseEntity.ok().body(dummyUser);
	}

	@PostMapping("/dummyusers")
    public DummyUser createDummyUser(@Valid @RequestBody DummyUser dummyUser) {
		return dummyUserRepo.save(dummyUser);
    }

    @PostMapping("/createuser")
	public ResponseEntity<Void> postDummyUser(@RequestBody DummyUser dummyUser) {
		DummyUser createdDummy = dummyUserRepo.save(dummyUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDummy.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/dummyusers/{id}")
    public ResponseEntity<DummyUser> updateDummyUser(@PathVariable(value = "id") Long dummyUserId,
         @Valid @RequestBody DummyUser dummyUserDetails) throws ResourceNotFoundException {
		System.out.println("Update Dummy : "+dummyUserId);
		DummyUser dummyUser = dummyUserRepo.findById(dummyUserId)
        .orElseThrow(() -> new ResourceNotFoundException("DummyUser not found for this id :: " + dummyUserId));

		dummyUser.setEmailId(dummyUserDetails.getEmailId());
		dummyUser.setLastName(dummyUserDetails.getLastName());
		dummyUser.setFirstName(dummyUserDetails.getFirstName());
        final DummyUser updatedDummyUser = dummyUserRepo.save(dummyUser);
        return ResponseEntity.ok(updatedDummyUser);
    }

	/**
	 *
	 * @param dummyUserId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/dummyusers/{id}")
    public Map<String, Boolean> deleteDummyUser(@PathVariable(value = "id") Long dummyUserId)
         throws ResourceNotFoundException {
		DummyUser dummyUser = dummyUserRepo.findById(dummyUserId)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + dummyUserId));

		dummyUserRepo.delete(dummyUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/dummyuser/{id}")
	public ResponseEntity<Void> deleteDummyUsers(@PathVariable(value = "id") Long dummyUserId)
		throws ResourceNotFoundException {
		String sql = "DELETE FROM dummyuser WHERE id = "+dummyUserId;

		if (jdbcTemplate.update(sql) == 1) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.noContent().build();
	}
}
