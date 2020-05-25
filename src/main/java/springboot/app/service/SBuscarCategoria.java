package springboot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import springboot.app.models.Categorias;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

@Service
public class SBuscarCategoria {
	
	public List<Categorias> getAll()
	{
		Regions region = Regions.SA_EAST_1; 
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(region)
				.build();
		String tableName = "Categorias";
		ScanRequest scan = new ScanRequest().withTableName(tableName); 
		ScanResult result = client.scan(scan);
		List<Categorias> list = new ArrayList<Categorias>();
		for(Map<String, AttributeValue> x : result.getItems())
		{
			Categorias cat = new Categorias();
			cat.setArquetipo(x.get("arquetipo").getS());
			cat.setAtar(Integer.parseInt(x.get("atar").getN()));
			cat.setAtleticas(Integer.parseInt(x.get("atleticas").getN()));
			cat.setCm(Integer.parseInt(x.get("cm").getN()));
			cat.setConvocar(Integer.parseInt(x.get("convocar").getN()));
			cat.setCreativas(Integer.parseInt(x.get("creativas").getN()));
			cat.setCv(Integer.parseInt(x.get("cv").getN()));
			cat.setCvinnatos(x.get("cvinnatos").getS());
			cat.setDesconvocar(Integer.parseInt(x.get("desconvocar").getN()));
			cat.setDominar(Integer.parseInt(x.get("dominar").getN()));
			cat.setHataque(Integer.parseInt(x.get("hataque").getN()));
			cat.setHesquiva(Integer.parseInt(x.get("hesquiva").getN()));
			cat.setHparada(Integer.parseInt(x.get("hparada").getN()));
			cat.setId(Integer.parseInt(x.get("id").getN()));
			cat.setIntelectuales(Integer.parseInt(x.get("intelectuales").getN()));
			cat.setKi(Integer.parseInt(x.get("ki").getN()));
			cat.setLimiteha(Integer.parseInt(x.get("limiteha").getN()));
			cat.setLimiteP(Integer.parseInt(x.get("limiteP").getN()));
			cat.setLimitesn(Integer.parseInt(x.get("limitesn").getN()));
			cat.setLlevararmadura(Integer.parseInt(x.get("llevararmadura").getN()));
			cat.setMultiploact(Integer.parseInt(x.get("multiploact").getN()));
			cat.setMultiploacumulacion(Integer.parseInt(x.get("multiploacumulacion").getN()));
			cat.setMultiplovida(Integer.parseInt(x.get("multiplovida").getN()));
			cat.setNombre(x.get("nombre").getS());
			cat.setPerceptivas(Integer.parseInt(x.get("perceptivas").getN()));
			//cat.setPicture(x.get("picture").getS());
			cat.setProyeccionmagica(Integer.parseInt(x.get("proyeccionmagica").getN()));
			cat.setProyeccionpsiquica(Integer.parseInt(x.get("proyeccionpsiquica").getN()));
			cat.setPv(Integer.parseInt(x.get("pv").getN()));
			cat.setSociales(Integer.parseInt(x.get("sociales").getN()));
			cat.setSubterfugio(Integer.parseInt(x.get("subterfugio").getN()));
			cat.setTurno(Integer.parseInt(x.get("turno").getN()));
			cat.setVigor(Integer.parseInt(x.get("vigor").getN()));
			cat.setZeon(Integer.parseInt(x.get("zeon").getN()));
			list.add(cat);
		}
				
		return list;
	}
}
