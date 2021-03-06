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

import net.tuto.pfe.projet.v4.Model.Eleve;
import net.tuto.pfe.projet.v4.Repository.EleveRepository;
import net.tuto.pfe.projet.v4.RessourceNotFoundException.RessourceNotFoundException;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EleveController {
	@Autowired
	private EleveRepository eleverepository;
	//getAllELEVE
	@GetMapping("/eleve")
	public List <Eleve> getAllEleve(){
		return eleverepository.findAll();
	}
	//createEleve
	@PostMapping("/eleves")
	public Eleve createEleve(@RequestBody Eleve eleve) {
		return eleverepository.save(eleve);
	}
	//getEleveById
	@GetMapping("/eleves/{id}")
	public ResponseEntity<Eleve> getElevebyId(@PathVariable long id) {
		Eleve eleve = eleverepository.findById(id).
		orElseThrow(()-> new RessourceNotFoundException("eleve with this id we dont have:"+id));
		return ResponseEntity.ok(eleve);
	}
	//UpdateEleve
	@PutMapping("/eleves/{id}")
	public ResponseEntity<Eleve> UpdateEleve(@PathVariable Long id , @RequestBody Eleve elevedetails){
		Eleve eleve = eleverepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("eleve with this id we dont have:"+id));
		eleve.setNom(elevedetails.getNom());
		eleve.setPrenom(eleve.getPrenom());
		eleve.setCin_par(elevedetails.getCin_par());
		eleve.setDate_naiss(elevedetails.getDate_naiss());
		eleve.setEmail(elevedetails.getEmail());
		eleve.setGender(elevedetails.getGender());
		eleve.setNiv_scolaire(elevedetails.getNiv_scolaire());
		eleve.setNom_etab(elevedetails.getNom_etab());
		eleve.setNom_mere(elevedetails.getNom_mere());
		eleve.setNom_pere(elevedetails.getNom_pere());
		eleve.setTel(elevedetails.getTel());
		eleve.setTel_mere(elevedetails.getTel_mere());
		eleve.setNom_pere(elevedetails.getNom_pere());
		Eleve UpdateEleve=eleverepository.save(eleve);
		return ResponseEntity.ok(UpdateEleve);
	}
	//DeleteEleve
	@DeleteMapping("/eleves/{id}")
	public  ResponseEntity<Map<String,Boolean>> deleteleve(@PathVariable long id){
		Eleve eleve = eleverepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("eleve with this id we dont have:"+id));
		eleverepository.delete(eleve);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	} 
	
}
