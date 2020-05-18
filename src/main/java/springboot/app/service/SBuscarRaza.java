package springboot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import springboot.app.models.Raza;

@Service
public class SBuscarRaza {
	
	public List<Raza> getAll(){
		
		Regions region = Regions.SA_EAST_1; 
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(region)
				.build();
		String tableName = "Razas";
		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable(tableName);
		ScanRequest scan = new ScanRequest().withTableName(tableName); 
		ScanResult result = client.scan(scan);
		List<Raza> list = new ArrayList<Raza>();
		for(Map<String, AttributeValue> item : result.getItems())//ESTO ES UN LISTA DE MAPAS
		{
			Raza r = new Raza();
			r.setId(Integer.parseInt(item.get("id").getN()));
			r.setRaza(item.get("raza").getS());
			r.setMisc(item.get("misc").getS());
			list.add(r);
		}
		return list;
	}
}
