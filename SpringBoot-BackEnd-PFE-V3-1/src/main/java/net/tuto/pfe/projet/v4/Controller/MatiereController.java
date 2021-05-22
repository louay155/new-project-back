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

import net.tuto.pfe.projet.v4.Model.Matiere;
import net.tuto.pfe.projet.v4.Repository.MatiereRepository;
import net.tuto.pfe.projet.v4.RessourceNotFoundException.RessourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class MatiereController {
	@Autowired
	private MatiereRepository matiereRepository ;
	
	//getAllMatiere
	@GetMapping("/matieres")
	public List<Matiere> getAllmatieres()
	{
		
		return matiereRepository.findAll();
	}
	//getAllMatiere
	@GetMapping("/matiere")

	//create matiere
	@PostMapping(value="/matieres/create")
	public Matiere creatematiere(@RequestBody Matiere matiere)
	{
		
		Matiere mat = matiereRepository.save( new  Matiere (matiere.getLibelle()));
		return mat;
	}
	//getmatiereById
	@GetMapping("/matieres/{id}")
	public ResponseEntity<Matiere> getMatById(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		return ResponseEntity.ok(matiere);
	}
	//updateMatiere
	@PutMapping("matieres/{id}")
	public ResponseEntity<Matiere> UpdateMatiere(@PathVariable long id , @RequestBody Matiere matieredetails)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiere.setLibelle(matieredetails.getLibelle());
		Matiere UpdateMatiere=matiereRepository.save(matiere);
		return ResponseEntity.ok(UpdateMatiere);
		
	}
	//DeleteMatiere
	@DeleteMapping("matieres/{id}")
	ResponseEntity<Map<String,Boolean>> deletmatiere(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiereRepository.delete(matiere);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}

	
}