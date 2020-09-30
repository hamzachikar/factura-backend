package com.springboot.project.gestionFacture.rest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Optional;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.Devis;
import com.springboot.project.gestionFacture.entity.Produit;
import com.springboot.project.gestionFacture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;
import com.springboot.project.gestionFacture.service.ClientService;
import com.springboot.project.gestionFacture.service.DevisService;
import com.springboot.project.gestionFacture.service.ProduitService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserRest {
	@Autowired
	private ClientService clientService;
	@Autowired
	private DevisService devisService;

	@Autowired
	private ProduitService produitService ;
	
	@Autowired
    SpringTemplateEngine templateEngine;
	
	//client management part
	//change this part when adding the auth module
	@GetMapping("/getAllClients")
	public List<Client> getClients(){
		return this.clientService.getClients();
	}
	@GetMapping("/getClient/{id}")
	public Optional<Client> getClient(@PathVariable int id){
		return this.clientService.getClient(id);
	}
	//change when add the auth module
	@PostMapping("/saveClient")
	public Client saveClient(@RequestBody Client client) {
		return this.clientService.save(client);
	}
	@DeleteMapping("/deleteClient/{id}")
	public void deleteClient(@PathVariable int id) {
		this.clientService.deleteClient(id);
	}
	
	
	//devis management part
	@PostMapping("/saveDevis")
	public Devis saveDevis(@RequestBody Devis devis) {
		return this.devisService.save(devis);
	}
	//change when add the auth module
	@GetMapping("/getAllDevis")
	public List <Devis> getDevis() {
	 	return this.devisService.getAllDevis();
	}
	
	@GetMapping("/getDevis/{id}")
	public Devis getDevis(@PathVariable int id){
		return this.devisService.getDevisById(id);
	}
	@GetMapping("/getDevis/user")
	public List<Devis> getDevisByUser(@RequestBody User user){
		return this.devisService.getDevisByUser(user);
	}
	@GetMapping("/getDevis/client")
	public List<Devis> getDevisByClient(@RequestBody Client client){
		return this.devisService.getDevisByClient(client);
	}
	@DeleteMapping("/deleteDevis/{id}")
	public void deleteDevis(@PathVariable int id) {
		this.devisService.deleteDevis(id);
	}
	
	
	//product management part
	@PostMapping("/produits")
	public Produit saveUsers(@RequestBody Produit produit) {
		return produitService.save(produit);
	}
	@GetMapping("/produits")
	public List<Produit> getAllProducts(){
		return this.produitService.getAllProduits();
	}

	
	//facture pdf generator part
	
	@GetMapping("/getFacturePDF")
    public ResponseEntity<InputStreamResource> loadFacturePDF(@RequestBody Devis devis) throws IOException, DocumentException {
        Context context = new Context();
        context.setVariable("devis",devis);
        String htmlContentToRender = templateEngine.process("pdf-template", context);
        String xHtml = xhtmlConvert(htmlContentToRender);

        ITextRenderer renderer = new ITextRenderer();
        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources","templates")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();
        OutputStream outputStream = new FileOutputStream("src//test.pdf");
        renderer.createPDF(outputStream); 
        outputStream.close();
        return ResponseEntity.ok()
        		.header("Content-disposition","inline; filename=facture.pdf")
        		.contentType(MediaType.APPLICATION_PDF)
        		.body(new InputStreamResource(new FileInputStream(new File("src//test.pdf"))));
    }

    private String xhtmlConvert(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes("UTF-8"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString("UTF-8");
    }
	
}
