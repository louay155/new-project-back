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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tuto.pfe.projet.v4.Model.Categorie;
import net.tuto.pfe.projet.v4.Repository.CategorieRepository;
import net.tuto.pfe.projet.v4.RessourceNotFoundException.RessourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class CategorieController {
	@Autowired
	private CategorieRepository categorierepository ;
	@GetMapping("categories")
	public List<Categorie> getallcategorie()
	{
		return categorierepository.findAll();
	}
	//create categorie
	@PostMapping("/categories")
	public Categorie createcat(@RequestBody Categorie categorie)
	{
		return categorierepository.save(categorie);
	}
	//deletecategorie
	@DeleteMapping("/categorie/{id}")
	ResponseEntity<Map<String, Boolean>> deletecat(@PathVariable long id)
	{
		Categorie categorie= categorierepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("categorie does not exist with this id:"+id));
		categorierepository.delete(categorie);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
