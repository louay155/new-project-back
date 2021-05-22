package net.tuto.pfe.projet.v4.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import net.tuto.pfe.projet.v4.Model.Seance;
import net.tuto.pfe.projet.v4.Repository.SeanceRepository;
import net.tuto.pfe.projet.v4.RessourceNotFoundException.RessourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class SeanceController {
	@Autowired
	private SeanceRepository seancerepository;
	//getAllseance
	@GetMapping("seance")
	public List<Seance> getallseance()
	
	{
		return seancerepository.findAll();
	}
	//create seance
	@PostMapping("seance")
	public Seance createseance(@RequestBody Seance seance)
	{
		return seancerepository.save(seance);
	}
	//getseanceById
	@GetMapping("seance/{id}")
	public ResponseEntity<Seance> getscebyid(@PathVariable long id)
	{
		Seance seance = seancerepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		return ResponseEntity.ok(seance);
	}
	//Updateseance
	@PutMapping("seance/{id}")
	public ResponseEntity<Seance> updateseance(@PathVariable long id , @RequestBody Seance seancedetails)
	{
		Seance seance= seancerepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		seance.setDate_sce(seancedetails.getDate_sce());
		seance.setHeure_deb(seancedetails.getHeure_deb());
		seance.setHeure_fin(seancedetails.getHeure_fin());
		seance.setSalle(seancedetails.getSalle());
		
		seance.setProf(seancedetails.getProf());
		Seance Updateseance=seancerepository.save(seance);
		return ResponseEntity.ok(Updateseance);
	}
	@DeleteMapping("/seance/{id}")
	ResponseEntity<Map<String,Boolean>> deleteseance(@PathVariable  long id)
	{
		Seance seance= seancerepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		seancerepository.delete(seance);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}
