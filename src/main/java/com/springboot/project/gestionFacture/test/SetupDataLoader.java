package com.springboot.project.gestionFacture.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springboot.project.gestionFacture.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.project.gestionFacture.jparepo.ParameterRepository;
import com.springboot.project.gestionFacture.jparepo.ProduitRepository;
import com.springboot.project.gestionFacture.service.ClientService;
import com.springboot.project.gestionFacture.service.DevisService;

import com.springboot.project.gestionFacture.service.ProductDevisService;
import com.springboot.project.gestionFacture.service.ProduitService;
import com.springboot.project.gestionFacture.service.UserService;


//@Component
public class SetupDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserService userS;
	@Autowired
	private ClientService clientS;
	@Autowired
	private DevisService devisS;
	@Autowired
	private ParameterRepository detailS;
	@Autowired
	private ProduitRepository productS;
	@Autowired
	private ProductDevisService pDevisS;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4); // Strength set as 16
        String encodedPassword1 = encoder.encode("complexe");
        String encodedPassword2= encoder.encode("test");
		User adminUser1 =new User("hamza chikar", "chikar.h@outlook.fr",encodedPassword1,"0613335547","admin","EE1111","responsable",null,null,true);
		User adminUser2 =new User("amjad babacheikh", "amjad.ab@outlook.fr",encodedPassword1,"0613335547","admin","EE1111","responsable",null,null,true);
		adminUser1=this.userS.save(adminUser1);
		adminUser2=this.userS.save(adminUser2);
		User empUser1=new User("emp1 emp1", "emp1@outlook.fr",encodedPassword2,"0613335547","user","EE1111","employee",null,adminUser1,true);
		User empUser2=new User("emp2 emp2", "emp2@outlook.fr",encodedPassword2,"0613335547","user","EE1111","employee",null,adminUser2,true);
		empUser1=this.userS.save(empUser1);
		empUser2=this.userS.save(empUser2);
		Client client1=new Client("client1","EE5756","Marrackech",400000,"Marrakech","skks5555","2225556630","client1@outlook.fr",adminUser1);
		Client client2=new Client("client2","EE5756","Marrackech",400000,"Marrakech","skks5555","2225556630","client2@outlook.fr",adminUser2);
		client1=this.clientS.save(client1);
		client2=this.clientS.save(client2);
		Produit prod1=new Produit("prod1",20.0,25.0,1000,"ejfnes",true, adminUser1,null);
		Produit prod2=new Produit("prod2",200.0,280.0,200,"ejfnecxcs",true,adminUser1,null);
		Produit prod3=new Produit("prod3",20,30,300,"ejfnescs",true,adminUser1,null);
		Produit prod4=new Produit("prod4",20.0,25.0,1000,"ejcsfnes",true,adminUser2,null);
		Produit prod5=new Produit("prod5",202.0,230.0,2000,"egfjfnes",true,adminUser2,null);
		Produit prod6=new Produit("prod6",25.0,30.0,1000,"ejfnfdges",true,adminUser2,null);
		prod1=this.productS.save(prod1);
		prod2=this.productS.save(prod2);
		prod3=this.productS.save(prod3);
		prod4=this.productS.save(prod4);
		prod5=this.productS.save(prod5);
		prod6=this.productS.save(prod6);
		ProductDevis p1=new ProductDevis(prod1, 5, "units");
		ProductDevis p2=new ProductDevis(prod2, 10, "units");
		ProductDevis p3=new ProductDevis(prod3, 30, "units");
		ProductDevis p4=new ProductDevis(prod4, 8, "units");
		ProductDevis p5=new ProductDevis(prod5, 1, "units");
		ProductDevis p6=new ProductDevis(prod6, 9, "units");
		p1=pDevisS.save(p1);
		p2=pDevisS.save(p2);
		p3=pDevisS.save(p3);
		p4=pDevisS.save(p4);
		p5=pDevisS.save(p5);
		p6=pDevisS.save(p6);
		List<ProductDevis> produits1=new ArrayList<ProductDevis>();
		produits1.add(p1);
		produits1.add(p2);
		produits1.add(p3);
		List<ProductDevis> produits2=new ArrayList<ProductDevis>();
		produits2.add(p4);
		produits2.add(p5);
		produits2.add(p6);
		Parameter detail1=new Parameter("the company test1", "0524371959", "MARRAKECH","theCompany1@outlook.com",null,null,null,adminUser1);
		Parameter detail2=new Parameter("the company test2", "0524371959", "MARRAKECH","theCompany2@outlook.com",null,null,null,adminUser2);
		detail1=this.detailS.save(detail1);
		detail2=this.detailS.save(detail2);
		Devis devis1=new Devis(new Date(), client1,empUser1,produits1,"155333", 20,"en attente");
		Devis devis2=new Devis(new Date(), client2,empUser2,produits2,"554896", 20,"en attente");
		devis1=this.devisS.save(devis1);
		devis2=this.devisS.save(devis2);
	}

}
